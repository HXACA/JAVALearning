package main.java;

import java.io.Serializable;

/**
 * @author liuxin
 * @version 1.0
 * @date 2020/3/6 20:04
 */

/*
饿汉式
1.获取效率高
2.线程安全
2.有时候会造成内存的浪费
3.反射和反序列化不安全
 */

public class Singleton1 implements Serializable{

    //2.静态的当前类的实例属性，静态变量不会再序列化中保存
    private static Singleton1 instance = new Singleton1();

    private Singleton1(){
        //1.私有化构造器
        System.out.println("singleton1");
    }

    //公有的获取当前实例对象的方法
    public static Singleton1 getInstance(){
        return instance;
    }

    private Object readResolve(){
        return instance;
    }

}
