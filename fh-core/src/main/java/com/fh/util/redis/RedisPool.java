package com.fh.util.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;


public class RedisPool {

    private static JedisPool pool;

    private static void initPoll(){
        JedisPoolConfig poolConfig = new JedisPoolConfig();
        poolConfig.setMaxWaitMillis(1000);
        poolConfig.setMinIdle(100);
        poolConfig.setMaxIdle(100);
        poolConfig.setTestOnBorrow(true);
        poolConfig.setTestOnReturn(true);
        pool=new JedisPool(poolConfig,"192.168.43.218",6379);
    }

    static {
        initPoll();
    }

    private RedisPool(){};

    public static Jedis getInstence(){
        return pool.getResource();
    }


}
