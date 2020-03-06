package main.java.utils;

import java.io.*;

/**
 * @author liuxin
 * @version 1.0
 * @date 2020/3/6 20:27
 */
public class SerializeUtil {

    public static void serialize(Object obj){
        //将对象序列化到obj中
        ObjectOutputStream outputStream = null;
        try {
            File file = new File("obj");
            outputStream = new ObjectOutputStream(new FileOutputStream(file));
            outputStream.writeObject(obj);
            outputStream.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static Object unSerialize(){
        ObjectInputStream inputStream = null;
        try {
            File file = new File("obj");
            inputStream = new ObjectInputStream(new FileInputStream(file));
            Object object = inputStream.readObject();
            return object;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

}
