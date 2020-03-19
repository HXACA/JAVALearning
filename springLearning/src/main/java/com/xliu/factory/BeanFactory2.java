package com.xliu.factory;

import com.xliu.service.AccountService;
import com.xliu.utils.TransactionManager;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * @author liuxin
 * @version 1.0
 * @date 2020/3/18 14:04
 */
public class BeanFactory2 {

    private AccountService accountService;

    private TransactionManager transactionManager;

    public void setTransactionManager(TransactionManager transactionManager) {
        this.transactionManager = transactionManager;
    }

    public void setAccountService(AccountService accountService) {
        this.accountService = accountService;
    }

    //获取代理对象
    public AccountService getAccountService() {
        return (AccountService) Proxy.newProxyInstance(accountService.getClass().getClassLoader(), accountService.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        if(!"transfer".equals(method.getName()))
                            return method.invoke(accountService,args);
                        Object rtValue = null;
                        try{
                            transactionManager.beginTransaction();
                            rtValue = method.invoke(accountService,args);
                            transactionManager.commitTransaction();
                            return rtValue;
                        }catch (Exception e){
                            transactionManager.roolbackTransaction();
                            throw new Exception(e);
                        }finally {
                            transactionManager.releaseTransaction();
                        }
                    }
                });
    }
}
