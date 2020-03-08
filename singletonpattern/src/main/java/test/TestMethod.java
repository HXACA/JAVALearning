package main.java.test;

import main.java.*;
import main.java.utils.SerializeUtil;
import org.junit.Test;

import java.io.IOException;
import java.lang.reflect.Constructor;

/**
 * @author liuxin
 * @version 1.0
 * @date 2020/3/6 20:08
 */
public class TestMethod {

    @Test
    public void test1() throws Exception {

        Class.forName("main.java.Singleton1");
        System.out.println("----pre----");

        /*
        singleton1
        ----pre----
        加载类的时候就触发构造
        */


        Singleton1 singleton1 = Singleton1.getInstance();
        Singleton1 singleton2 = singleton1.getInstance();
        System.out.println(singleton1 == singleton2);
        //true,为同一个对象

        Class clazz = Singleton1.class;
        Constructor constructor = clazz.getDeclaredConstructor();
        constructor.setAccessible(true);
        singleton2 = (Singleton1) constructor.newInstance();
        System.out.println(singleton1 == singleton2);
        //false,出现不同的对象，对于反射不安全


        SerializeUtil.serialize(singleton1);
        singleton1 = (Singleton1) SerializeUtil.unSerialize();
        singleton2 = (Singleton1) SerializeUtil.unSerialize();
        System.out.println(singleton1 == singleton2);
        //false,出现不同的对象，对于反序列化不安全,通过实现readResolve,保证每次返回的是同一个对象
    }

    @Test
    public void test2() throws Exception {
        Class.forName("main.java.Singleton2");
        System.out.println("----pre----");
        /*
         ----pre----
        singleton2
        未使用Singleton2时不会触发构造方法
        */
        Singleton2 singleton1 = Singleton2.getInstance();
        Singleton2 singleton2 = Singleton2.getInstance();
        System.out.println(singleton1 == singleton2);
        //true,为同一个对象

//        Class clazz = Singleton2.class;
//        Constructor constructor = clazz.getDeclaredConstructor();
//        constructor.setAccessible(true);
//        singleton2 = (Singleton2) constructor.newInstance();
//        System.out.println(singleton1 == singleton2);
        //false,出现不同的对象，在构造方法中添加判断禁用反射

        SerializeUtil.serialize(singleton2);
        singleton1 = (Singleton2) SerializeUtil.unSerialize();
        singleton2 = (Singleton2) SerializeUtil.unSerialize();
        System.out.println(singleton1 == singleton2);
        //false,出现不同的对象，对于反序列化不安全,通过实现readResolve,保证每次返回的是同一个对象

    }

    @Test
    public void test3() throws Exception {
        Singleton3 singleton1 = Singleton3.INSTANCE;
        Singleton3 singleton2 = Singleton3.INSTANCE;
        System.out.println(singleton1==singleton2);
        //true


//        Class clazz = Singleton3.class;
//        Constructor constructor = clazz.getDeclaredConstructor();
//        constructor.setAccessible(true);
//        singleton2 = (Singleton3) constructor.newInstance();
//        System.out.println(singleton1 == singleton2);
        //枚举类没有构造方法，无法反射

        SerializeUtil.serialize(singleton1);
        singleton1 = (Singleton3) SerializeUtil.unSerialize();
        singleton2 = (Singleton3) SerializeUtil.unSerialize();
        System.out.println(singleton1 == singleton2);
        //true

        Singleton3.INSTANCE.doSomething();
    }

    @Test
    public void test4() throws Exception {
//        Singleton4 singleton1 = Singleton4.getInstance();
//        Singleton4 singleton2 = Singleton4.getInstance();
//        System.out.println(singleton1==singleton2);

        for(int i=0;i<20;i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Singleton4.getInstance());
                }
            }).start();
        }
        //非线程安全，可以加 synchronized 但效率低，使用双检锁优化，添加volatile避免指令重排

        System.in.read();//阻塞主线程
    }

    @Test
    public void test5() throws Exception{
//        Singleton5 singleton1 = Singleton5.getInstance();
//        Singleton5 singleton2 = Singleton5.getInstance();
//        System.out.println(singleton1==singleton2);

        for(int i=0;i<20;i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    Singleton5 singleton1 = Singleton5.getInstance();
                    Singleton5 singleton2 = Singleton5.getInstance();
                    System.out.println(Thread.currentThread().getName() +" "+ (singleton1 == singleton2) +" "+ singleton1);
                }
            }).start();
        }
        //同线程内单例，非同线程不同对象
        System.in.read();//阻塞主线程
    }

    @Test
    public void test6() throws Exception{
        for(int i=0;i<20;i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    Singleton6 singleton1 = Singleton6.getInstance();
                    Singleton6 singleton2 = Singleton6.getInstance();
                    System.out.println(Thread.currentThread().getName() +" "+ (singleton1 == singleton2) +" "+ singleton1);
                }
            }).start();
        }
        System.in.read();//阻塞主线程
    }

}
