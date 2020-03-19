package com.xliu.service.impl;

import com.xliu.bean.Account;
import com.xliu.dao.AccountDao;
import com.xliu.service.AccountService;
import com.xliu.utils.TransactionManager;

import java.util.Date;
import java.util.List;


/**
 * @author liuxin
 * @version 1.0
 * @date 2020/3/18 13:58
 */
public class AccountServiceImpl implements AccountService {

    private AccountDao accountDao;

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    public List<Account> findAllAccount() {
        return accountDao.findAllAccount();
    }

    public Account findAccountById(Integer accountId) {
        return accountDao.findAccountById(accountId);
    }

    public void saveAccount(Account account) {
        accountDao.saveAccount(account);
    }

    public void updateAccount(Account account) {
        accountDao.updateAccount(account);
    }

    public void deleteAccount(Account account) {
        accountDao.deleteAccount(account);
    }

    public void transfer(String sourceName,String targetName,Float money){
            Account source = accountDao.findAccountByName(sourceName);
            Account target = accountDao.findAccountByName(targetName);
            source.setMoney(source.getMoney()-money);
            target.setMoney(target.getMoney()+money);
            accountDao.updateAccount(source);
            int a = 3/0;
            accountDao.updateAccount(target);
    }

}
