package main.java;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @author liuxin
 * @version 1.0
 * @date 2020/3/8 19:27
 */

/*
CAS,利用原子性进行操作，部分情况会造成资源浪费
 */
public class Singleton6 {
    private static final AtomicReference<Singleton6> instance = new AtomicReference<>();
    private Singleton6(){
        System.out.println("singleton6");
    }

    public static final Singleton6 getInstance(){
        Singleton6 current = instance.get();
        if(current!=null){
            return current;
        }
        current = new Singleton6();
        if(instance.compareAndSet(null,current)){//原子类操作
            return current;
        }else{
            return getInstance();//解决多线程时没有进行原子类操作的线程的情况
        }
    }
}
