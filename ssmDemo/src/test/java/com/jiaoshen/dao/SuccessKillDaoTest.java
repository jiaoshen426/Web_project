package com.jiaoshen.dao;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.jiaoshen.enpty.SuccessKilled;


@RunWith(SpringJUnit4ClassRunner.class)
//∏ÊÀﬂjunit spring≈‰÷√Œƒº˛
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class SuccessKillDaoTest {
    @Resource
    SuccessKilledDao successKillDao;
	@Test
	public void testInsrrtSuccessKilled() {
		long id=1001;
		String phone="13724918642";
		successKillDao.insertSuccessKilled(id, phone);
		
	}

	@Test
	public void testQueryByIdWithSeckill() {
		long id=1000;
		String phone="13724918642";
		 SuccessKilled sue= successKillDao.queryByIdWithSeckill(id, phone);
		 System.out.println("sue"+sue);
		 System.out.println("sue.getSeckill().getName()"+sue.getSeckill().getName());
		
	}

}
