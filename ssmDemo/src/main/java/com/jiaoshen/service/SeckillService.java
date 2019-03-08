package com.jiaoshen.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jiaoshen.dto.Exposer;
import com.jiaoshen.dto.SeckillExecution;
import com.jiaoshen.enpty.Seckill;
import com.jiaoshen.exception.SeckillException;

public interface SeckillService {
	/**
	 * 
	 * ��ѯ������ɱ��¼
	 * 
	 */
	 List<Seckill> getSeckillList();
	 
	 /**
	  * ��ѯ������ɱ��¼
	  * @param seckillId
	  * @return 
	  */
	
	 Seckill getById(long seckillId);
	 
	 /**
	  * ��ɱ�����������ɱ�ӿڵ�ַ
	  * �������ϵͳʱ�����ɱʱ��
	  * @param seckillId
	  * @return
	  */
	 Exposer exportSeckillUrl(long seckillId);
	 
	 /**
	  * ִ����ɱ����
	  * @param seckillId
	  * @param userPhone
	  * @param md5
	  * @return
	  */
	SeckillExecution executeSeckill(long seckillId,String userPhone,String md5);

}
