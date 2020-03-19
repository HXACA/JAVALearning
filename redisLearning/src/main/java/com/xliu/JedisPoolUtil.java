package com.xliu;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @author liuxin
 * @version 1.0
 * @date 2020/3/18 13:03
 */
public class JedisPoolUtil {
    private static volatile JedisPool jedisPool = null; //volatile避免指令重排

    private JedisPoolUtil(){

    }

    public static JedisPool getJedisPoolInstance(){
        if(jedisPool == null){
            synchronized (JedisPoolUtil.class){
                if(jedisPool==null){
                    JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
                    jedisPoolConfig.setMaxTotal(1000);
                    jedisPoolConfig.setMaxIdle(32);
                    jedisPoolConfig.setMaxWaitMillis(100*1000);
                    jedisPoolConfig.setTestOnBorrow(true);
                    jedisPool = new JedisPool(jedisPoolConfig,"192.168.198.128",6379);
                }
            }
        }
        return jedisPool;
    }

    public static void release(Jedis jedis){
        if(jedis!=null){
            jedis.close();
        }
    }
}
