package com.xliu;

import redis.clients.jedis.Jedis;

/**
 * @author liuxin
 * @version 1.0
 * @date 2020/3/19 16:49
 */

//点赞操作
public class HomeWork {
    public static void main(String[] args) {
        Jedis jedis = null;
        try {
            jedis = JedisPoolUtil.getJedisPoolInstance().getResource();
            //点赞
            for (int i = 0; i < 5; i++)
                jedis.setbit("photo:1", i, String.valueOf(1));
            //查看是否点赞
            for (int i = 0; i < 7; i++) {
                Boolean getbit = jedis.getbit("photo:1", i);
                System.out.println(i + (getbit ? " 点赞了" : "没点赞"));
            }
            Long bitcount = jedis.bitcount("photo:1");
            System.out.println("共有"+bitcount+"个赞");
            //取消点赞
            for (int i = 0; i < 2; i++) {
                jedis.setbit("photo:1", i, String.valueOf(0));
                System.out.println(i + " 取消了点赞");
            }
            bitcount = jedis.bitcount("photo:1");
            System.out.println("共有"+bitcount+"个赞");
        } finally {
            if (jedis != null)
                JedisPoolUtil.release(jedis);
        }

    }
}
