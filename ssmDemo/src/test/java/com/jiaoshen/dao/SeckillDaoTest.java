package com.jiaoshen.dao;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.jiaoshen.enpty.Seckill;
/**
 * 配置spring和junit整合，junit启动时加载springIOC容器
 * spring-test,junit
 * 
 */

@RunWith(SpringJUnit4ClassRunner.class)
//告诉junit spring配置文件
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class SeckillDaoTest {
	@Resource
	private SeckillDao seqkillDao;
	@Test
	public void testReduceNumber() {
		 long id=1000;
		 Date d1=new Date();
		 int i=seqkillDao.reduceNumber(id, d1);
		 System.out.println(i);
		 
	}

	@Test
	public void testQueryById() {
		long id=1000;
		Seckill seckill=seqkillDao.queryById(id);
		System.out.println(seckill.getName());
	    System.out.println(seckill);
		//fail("Not yet implemented");
	}

	@Test
	public void testQueryAll() {
		List<Seckill> l1=seqkillDao.queryAll(0, 50);
		System.out.println();
		for(Seckill s:l1){
			System.out.println(s);
		}
		
	
	}

}
