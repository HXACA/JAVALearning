package com.xliu.ui;

import com.xliu.factory.BeanFactory;
import com.xliu.service.AccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author liuxin
 * @version 1.0
 * @date 2020/3/18 14:01
 */
public class Client {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
        AccountService as = (AccountService) applicationContext.getBean("accountService");
    }
}
