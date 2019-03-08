package com.jiaoshen.dao;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.jiaoshen.dao.cache.RedisDao;
import com.jiaoshen.enpty.Seckill;

/**
 * 
 * @author jiaoshen
 * @date   2018年1月29日
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class RedisDaoTest {
    private long id=1001;
    @Autowired
    private RedisDao redisDao;
    
    @Autowired
    private SeckillDao seckillDao;
    
    @Test
    public void testSeckill(){
    	Seckill seckill=redisDao.getSeckill(id);
    	if(seckill==null){
    		 seckill=seckillDao.queryById(id);
    		 System.out.println("=====mysql:"+seckill);
    		 redisDao.putSeckill(seckill);
    		 seckill=redisDao.getSeckill(id);
    		 System.out.println("=====redis:"+seckill);
    		
    	}
    }
	@Test
	public void testRedisDao() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.jiaoshen.dao.cache.RedisDao#getSeckill(long)}.
	 */
	@Test
	public void testGetSeckill() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.jiaoshen.dao.cache.RedisDao#putSeckill(com.jiaoshen.enpty.Seckill)}.
	 */
	@Test
	public void testPutSeckill() {
		fail("Not yet implemented");
	}

}
