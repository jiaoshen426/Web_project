package com.jiaoshen.service;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.jiaoshen.dto.Exposer;
import com.jiaoshen.dto.SeckillExecution;
import com.jiaoshen.enpty.Seckill;

/**
 * 
 * @author jiaoshen
 * @date   2018年1月3日
 */
@RunWith(SpringJUnit4ClassRunner.class)
//告诉junit spring配置文件
@ContextConfiguration({"classpath:spring/spring-dao.xml",
	                  "classpath:spring/spring-service.xml"})
public class SeckillServiceTest {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
    @Autowired
	private SeckillService seckillService; 
	/**
	 * Test method for {@link com.jiaoshen.service.SeckillService#getSeckillList()}.
	 */
	@Test
	public void testGetSeckillList() {
		List<Seckill> list=seckillService.getSeckillList();
		logger.info("list={}",list);
	}

	/**
	 * Test method for {@link com.jiaoshen.service.SeckillService#getById(long)}.
	 */
	@Test
	public void testGetById() {
		long id=1000;
		Seckill seckill=seckillService.getById(id);
		logger.info("list={}",seckill);
	}

	/**
	 * Test method for {@link com.jiaoshen.service.SeckillService#exportSeckillUrl(long)}.
	 */
	@Test
	public void testExportSeckillUrl() {
		long id=1000;
		Exposer exposer=seckillService.exportSeckillUrl(id);
		logger.info("list={}",exposer);
	}

	/**
	 * Test method for {@link com.jiaoshen.service.SeckillService#executeSeckill(long, java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testExecuteSeckill() {
		String md5="158c17b67f460acbfdd100501fe02b6c";
		long id=1000;
		String  phone="13760260779";
		SeckillExecution excution=seckillService.executeSeckill(id, phone, md5);
		logger.info("result={}",excution);
	}

}
