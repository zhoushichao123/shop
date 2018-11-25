package com.fh.util.redis;

import redis.clients.jedis.Jedis;

public class RedisUtil {

    public static void set(String key , String value){
        Jedis jedis=null;
        try {
            jedis = RedisPool.getInstence();
            jedis.set(key,value);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
           jedis.close();
            jedis=null;
        }
    }

    public static String get(String key){
        Jedis jedis=null;
        String result="";
        try {
            jedis = RedisPool.getInstence();
            result=jedis.get(key);
        }catch (Exception e){
            e.printStackTrace();
            return result;
        }finally {
            jedis.close();
            jedis=null;
        }
        return result;
    }

    public static void expire(String key ,int seconds){
        Jedis jedis=null;
        try {
            jedis = RedisPool.getInstence();
            jedis.expire(key,seconds);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            jedis.close();
            jedis=null;
        }
    }


    public static void main(String[] args) {
       //set("nknknk","bvsjbhv");
        String result = get("nknknk");
        System.out.println(result);
    }

    public static boolean setNxExpire(String key,String value, int time) {
        Jedis jedis=null;
        try {
            jedis = RedisPool.getInstence();
            Long setnx = jedis.setnx(key, value);
            if (setnx==1){
                jedis.expire(key, time);
                return true;
            }else {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            jedis.close();
            jedis=null;
        }
        return false;
    }

    public static Long incrEcpire(String key, int seconds) {
        Jedis jedis=null;
        Long value=0l;
        try {
            jedis = RedisPool.getInstence();
            value = jedis.incr(key);
            if (value==1){
                jedis.expire(key,seconds);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            jedis.close();
            jedis=null;
        }
        return value;
    }
}