package com.xliu;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author liuxin
 * @version 1.0
 * @date 2020/3/18 12:09
 */

public class TestPing {
    public static void main(String[] args) {
        Jedis jedis = JedisPoolUtil.getJedisPoolInstance().getResource();
        //key
        Set<String> keys = jedis.keys("*");
        System.out.println("keys:");
        for (String key : keys) {
            System.out.println(key);
        }
        System.out.println("----------------------------");
        System.out.println("jedis exist " + jedis.exists("k2"));
        System.out.println("jedis ttl " + jedis.ttl("k2"));
        System.out.println("jedis get " + jedis.get("k2"));

        //String
        jedis.set("k1","v1");
        //jedis.append("k1","liuxin append");
        System.out.println(jedis.get("k1"));
        //jedis.set("k4", "java_redis_k4");
        //jedis.mset("k5","v5","k6","v6","k7","v7");
        System.out.println(jedis.mget("k1","k2","k3","k5","k6","k7"));

        //list
        //jedis.lpush("mylist","v1","v2","v3","v4","v5");
        System.out.println(jedis.lrange("mylist",0,-1));

        //Set
        jedis.sadd("orders","jd001","jd002","jd003");
        Set<String> orders = jedis.smembers("orders");
        System.out.println(orders);
        jedis.srem("orders","jd002");
        System.out.println(jedis.smembers("orders"));

        //hash
        jedis.hset("hash1","username","liuxin");
        System.out.println(jedis.hget("hash1","username"));
        Map<String,String> map = new HashMap<>();
        map.put("telephone","123456");
        map.put("email","718531794@qq.com");
        jedis.hmset("hash1",map);
        List<String> hmget = jedis.hmget("hash1", "username", "telephone", "email");
        System.out.println(hmget);

        //Zset
        jedis.zadd("zset01",60,"v1");
        jedis.zadd("zset01",70,"v2");
        jedis.zadd("zset01",80,"v3");
        jedis.zadd("zset01",90,"v4");
        jedis.zadd("zset01",100,"v5");
        System.out.println(jedis.zrangeByScore("zset01",80,100));
        System.out.println(jedis.zrange("zset01",0,-1));

        JedisPoolUtil.release(jedis);
    }
}
