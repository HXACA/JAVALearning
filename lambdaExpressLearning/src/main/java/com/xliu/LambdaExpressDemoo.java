package com.xliu;

/**
 * @author liuxin
 * @version 1.0
 * @date 2020/3/16 18:26
 */

interface Foo{
    public String sayHello(String s);
    default int add(int x,int y){
        System.out.println(x+y);
        return x+y;
    }
    public static int mul(int x,int y){
        System.out.println(x*y);
        return x*y;
    }
}

public class LambdaExpressDemoo {
    public static void main(String[] args) {

        String s = "liuxin";

        Foo foo = new Foo() {
            @Override
            public String sayHello(String ss) {
                System.out.println(ss);
                return ss;
            }
        };
        foo.sayHello(s);

        Foo foo2 = (ss) -> {
            System.out.println(ss);
            return ss;
        };
        foo2.sayHello(s);
        foo2.add(1,2);
        Foo.mul(2,3);
    }
}
