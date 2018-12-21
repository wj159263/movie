package com.movie.dao.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.movie.dao.RedisDao;
import com.movie.dto.EyUIGridResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import javax.annotation.Resource;
import java.io.IOException;

@Component
public class RedisDaoImpl implements RedisDao{
    @Autowired
    JedisPool jedisPool;

    @Override
    public String get(String key) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            return  jedis.get(key);
        }finally {
            if (jedis != null){
                jedis.close();
            }
        }
    }

    @Override
    public String set(String key, String value) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            return jedis.set(key, value);
        }finally {
            if (jedis != null){
                jedis.close();
            }
        }
    }

    @Override
    public String hget(String hkey, String key) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            return jedis.hget(hkey,key);
        }finally {
            if (jedis != null){
                jedis.close();
            }
        }
    }

    @Override
    public long hset(String hkey, String key, String value) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            return jedis.hset(hkey, key, value);
        }finally {
            if (jedis != null){
                jedis.close();
            }
        }
    }

    @Override
    public long incr(String key) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            return jedis.incr(key);
        }finally {
            if (jedis != null){
                jedis.close();
            }
        }
    }

    @Override
    public long expire(String key, int second) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            return jedis.expire(key, second);
        }finally {
            if (jedis != null){
                jedis.close();
            }
        }
    }

    @Override
    public long ttl(String key) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            return jedis.ttl(key);
        }finally {
            if (jedis != null){
                jedis.close();
            }
        }
    }

    @Override
    public long del(String key) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            return jedis.del(key);
        }finally {
            if (jedis != null){
                jedis.close();
            }
        }
    }

    @Override
    public long hdel(String hkey, String key) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            return jedis.hdel(hkey, key);
        }finally {
            if (jedis != null){
                jedis.close();
            }
        }
    }

    @Override
    public EyUIGridResult getCenterData() throws IOException {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            String data = jedis.hget("video:", "center");
            if(data != null) {
                ObjectMapper mapper = new ObjectMapper();
                EyUIGridResult result = mapper.readValue(data.getBytes(), EyUIGridResult.class);
                return result;
            }
            return null;
        }finally {
            if (jedis != null){
                jedis.close();
            }
        }
    }

    @Override
    public void synchronizeCenter(String data) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            jedis.hset("video:", "center",data);
        }finally {
            if (jedis != null){
                jedis.close();
            }
        }
    }
}
