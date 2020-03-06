package main.java;

import java.io.Serializable;

/**
 * @author liuxin
 * @version 1.0
 * @date 2020/3/6 20:04
 */

/*
登记式,静态内部类
 */

public class Singleton2 implements Serializable{

    private static class SingletonHolder{
        private static Singleton2 instance = new Singleton2();
    }

    private Singleton2(){
        System.out.println("singleton2");
        if(SingletonHolder.instance!=null){
            throw new IllegalStateException();
        }
    }

    //只有在触发get方法时才会生成实例，减少其他时的消耗
    public static Singleton2 getInstance(){
        return SingletonHolder.instance;
    }

    private Object readResolve(){
        return SingletonHolder.instance;
    }

}
