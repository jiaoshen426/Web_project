package com.jiaoshen.dao;

import org.apache.ibatis.annotations.Param;

import com.jiaoshen.enpty.SuccessKilled;

public interface SuccessKilledDao {
    
	/**
	 * 插入购买明细，可过滤重复
	 * @param seckillId
	 * @param userPhone
	 * @return
	 */
	int  insertSuccessKilled(@Param("seckillId")long seckillId,@Param("userPhone")String userPhone);
	
	
	/**
	 * 根据id查询SuccessKilled并携带秒杀产品对象实体
	 * @param seckillId
	 * @return
	 */
	SuccessKilled queryByIdWithSeckill(@Param("seckillId")long seckillId,@Param("userPhone")String userPhone);
	
}
