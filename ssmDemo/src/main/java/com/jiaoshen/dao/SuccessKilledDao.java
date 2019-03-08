package com.jiaoshen.dao;

import org.apache.ibatis.annotations.Param;

import com.jiaoshen.enpty.SuccessKilled;

public interface SuccessKilledDao {
    
	/**
	 * ���빺����ϸ���ɹ����ظ�
	 * @param seckillId
	 * @param userPhone
	 * @return
	 */
	int  insertSuccessKilled(@Param("seckillId")long seckillId,@Param("userPhone")String userPhone);
	
	
	/**
	 * ����id��ѯSuccessKilled��Я����ɱ��Ʒ����ʵ��
	 * @param seckillId
	 * @return
	 */
	SuccessKilled queryByIdWithSeckill(@Param("seckillId")long seckillId,@Param("userPhone")String userPhone);
	
}
