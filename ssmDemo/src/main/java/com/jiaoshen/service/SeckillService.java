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
	 * 查询所有秒杀记录
	 * 
	 */
	 List<Seckill> getSeckillList();
	 
	 /**
	  * 查询单个秒杀记录
	  * @param seckillId
	  * @return 
	  */
	
	 Seckill getById(long seckillId);
	 
	 /**
	  * 秒杀开启是输出秒杀接口地址
	  * 否则输出系统时间和秒杀时间
	  * @param seckillId
	  * @return
	  */
	 Exposer exportSeckillUrl(long seckillId);
	 
	 /**
	  * 执行秒杀操作
	  * @param seckillId
	  * @param userPhone
	  * @param md5
	  * @return
	  */
	SeckillExecution executeSeckill(long seckillId,String userPhone,String md5);

}
