package com.xliu;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Transaction;

/**
 * @author liuxin
 * @version 1.0
 * @date 2020/3/18 12:41
 */
public class TestTX {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("192.168.198.128",6379);
        Transaction transaction = jedis.multi();
    }
}
