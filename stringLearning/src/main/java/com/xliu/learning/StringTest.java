package com.xliu.learning;

/**
 * @author liuxin
 * @version 1.0
 * @date 2020/3/16 16:31
 */
public class StringTest {


    public static void main(String[] args) {
        String string = "liuxin";
        String string2 = "liuxin2";
        String string3 = "liuxinliuxin2";
        System.out.println(string3 == (string+string2));
        System.out.println(string3.equals(string+string2));
    }
}
