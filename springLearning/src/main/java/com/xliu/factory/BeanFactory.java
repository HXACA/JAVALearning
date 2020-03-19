package com.xliu.factory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * @author liuxin
 * @version 1.0
 * @date 2020/3/18 14:04
 */
public class BeanFactory {

    private static Properties props;

    private static Map<String,Object> beans;

    static {
        props = new Properties();
        InputStream in = BeanFactory.class.getClassLoader().getResourceAsStream("bean.properties");
        try {
            props.load(in);
        } catch (IOException e) {
            e.printStackTrace();
            throw new ExceptionInInitializerError(e);
        }
        beans = new HashMap<>();
        Enumeration<Object> keys = props.keys();
        while(keys.hasMoreElements()){
            String key = keys.nextElement().toString();
            String beanPath  = props.getProperty(key);
            try {
                Object bean = Class.forName(beanPath).newInstance();
                beans.put(key,bean);
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

        }
    }

    public static Object getBean(String beanName){
        return beans.get(beanName);
    }


}
