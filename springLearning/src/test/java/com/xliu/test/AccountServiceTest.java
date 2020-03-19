package com.xliu.test;

import com.xliu.bean.Account;
import com.xliu.service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @author liuxin
 * @version 1.0
 * @date 2020/3/18 16:16
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:bean.xml")
public class AccountServiceTest {

    @Autowired
    @Qualifier("proxyAccountService")
    private AccountService accountService;

    @Test
    public void testFindAll(){
        List<Account> allAccount = accountService.findAllAccount();
        System.out.println(allAccount);
    }
    @Test
    public void testFindOne(){
        Account accountById = accountService.findAccountById(3);
        System.out.println(accountById);
    }
    @Test
    public void testSave(){
        Account account = new Account();
        account.setId(3);
        account.setMoney(1000f);
        account.setName("liuxin");
        accountService.saveAccount(account);
    }
    @Test
    public void testUpdate(){

    }
    @Test
    public void testDelete(){

    }

    @Test
    public void testTransfer(){
        accountService.transfer("aaa","bbb",100f);
    }

}
