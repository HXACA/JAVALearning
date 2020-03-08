package main.java;

/**
 * @author liuxin
 * @version 1.0
 * @date 2020/3/6 20:04
 */

/*
懒汉式
 */

public class Singleton4 {

    private static volatile Singleton4 instance = null;

    private Singleton4() {

    }

    public static Singleton4 getInstance() {
        if (instance == null) {
            synchronized (Singleton4.class) {
                if(instance==null)
                    instance = new Singleton4();
            }
        }
        return instance;
    }

}
