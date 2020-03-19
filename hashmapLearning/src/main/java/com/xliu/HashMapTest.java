package com.xliu;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author liuxin
 * @version 1.0
 * @date 2020/3/18 21:58
 */
public class HashMapTest {
    public static void main(String[] args) {
        HashMap<String,String>hashMap;
        ConcurrentHashMap<String,String>concurrentHashMap;
        Hashtable<String,String>hashtable;
        String s = new String("hello");
        String t = new String("hello");
        System.out.println(s == t);
        s = "hello";
        t = "hello";
        System.out.println(s == t);
        int a[] = new int[20];
        float b[] = new float[20];
        System.out.println(a.getClass());
        System.out.println(b.getClass());
    }
}
