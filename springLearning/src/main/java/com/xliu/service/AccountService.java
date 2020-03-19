package com.xliu.service;

import com.xliu.bean.Account;

import java.util.List;

/**
 * @author liuxin
 * @version 1.0
 * @date 2020/3/18 13:57
 */
public interface AccountService {
    List<Account> findAllAccount();
    Account findAccountById(Integer accountId);
    void saveAccount(Account account);
    void updateAccount(Account account);
    void deleteAccount(Account account);
    void transfer(String sourceName,String targetName,Float money);
}
