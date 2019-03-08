package com.jiaoshen.service.impl;

import com.jiaoshen.dao.SeckillDao;
import com.jiaoshen.dao.SuccessKilledDao;
import com.jiaoshen.dao.cache.RedisDao;
import com.jiaoshen.dto.Exposer;
import com.jiaoshen.dto.SeckillExecution;
import com.jiaoshen.enpty.Seckill;
import com.jiaoshen.enpty.SuccessKilled;
import com.jiaoshen.enums.SeckillStatEnum;
import com.jiaoshen.exception.RepeatKillException;
import com.jiaoshen.exception.SeckillCloseException;
import com.jiaoshen.exception.SeckillException;
import com.jiaoshen.service.SeckillService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;

import java.util.Date;
import java.util.List;

/**
 * 
 * @author jiaoshen
 * @date 2017��12��24��
 */
@Service
public class SeckillServiceImpl implements SeckillService {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private RedisDao redisDao;
	@Autowired
	private SeckillDao seckillDao;
	@Autowired
	private SuccessKilledDao successKilledDao;

	// md5����ֵ
	private final String slat = "qwe";
    @Override
	public List<Seckill> getSeckillList() {
		return seckillDao.queryAll(0, 10);
	}
    
    @Override
	public Seckill getById(long seckillId) {
		return seckillDao.queryById(seckillId);
	}
    
    @Override
	public Exposer exportSeckillUrl(long seckillId) {
		// 优化点 ：缓存优化
		Seckill seckill = redisDao.getSeckill(seckillId);
		if (seckill == null) {
			seckill = seckillDao.queryById(seckillId);
			if (seckill == null) {
				return new Exposer(false, seckillId);
			} else {
				redisDao.putSeckill(seckill);
			}
		}

		Date nowTime = new Date();
		Date startTime = seckill.getStartTime();
		Date endTime = seckill.getEndTime();
		if (nowTime.getTime() > endTime.getTime() || nowTime.getTime() < startTime.getTime()) {
			return new Exposer(false, seckillId, nowTime.getTime(), startTime.getTime(), endTime.getTime());
		}
		// md5���� ��ת���ض��ַ�����������
		String md5 = getMD5(seckillId);
		return new Exposer(true, md5, seckillId);
	}

	private String getMD5(long seckillId) {
		String base = seckillId + "/" + slat;
		String md5 = DigestUtils.md5DigestAsHex(base.getBytes());
		return md5;
	}
	@Override
	@Transactional
	public SeckillExecution executeSeckill(long seckillId, String userPhone, String md5) throws SeckillException {
		if (md5 == null || !md5.equals(getMD5(seckillId))) {
			throw new SeckillException("seckill data rewrite");
		}
		Date nowTime = new Date();
		int updateCount = seckillDao.reduceNumber(seckillId, nowTime);
		try {

			if (updateCount <= 0) {
				// û�и��¼�¼ ��ɱ����
				throw new SeckillCloseException("seckill is closed");
			} else {
				// ��¼������Ϊ
				int insertCount = successKilledDao.insertSuccessKilled(seckillId, userPhone);
				if (insertCount <= 0) {
					// �ظ���ɱ
					throw new RepeatKillException("seckill repeat");
				} else {
					// ��ɱ�ɹ�
					SuccessKilled successKilled = successKilledDao.queryByIdWithSeckill(seckillId, userPhone);
					return new SeckillExecution(seckillId, SeckillStatEnum.SUCCESS, successKilled);
				}
			}
		} catch (SeckillCloseException e1) {
			throw e1;

		} catch (RepeatKillException e2) {
			throw e2;

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			// ���б����쳣 ת��Ϊ�������쳣
			throw new SeckillCloseException("esckill inner error " + e.getMessage());
		}
	}

}
