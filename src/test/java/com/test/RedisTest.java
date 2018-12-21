package com.test;

import com.movie.service.impl.VideoServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class RedisTest {

    @Test
    public void testGet(){
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-*.xml");
        context.getBean("dataSource");
        JedisPool pool = (JedisPool) context.getBean("redisClient");
       Jedis jedis = pool.getResource();
       jedis.set("a","20");
        System.out.println(jedis.get("a"));
        jedis.expire("a",20);
        System.out.println(jedis.ttl("a"));
    }
}
