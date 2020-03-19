package com.xliu.dao;

import com.xliu.bean.Account;

import java.util.List;

/**
 * @author liuxin
 * @version 1.0
 * @date 2020/3/18 13:59
 */
public interface AccountDao {
    List<Account> findAllAccount();
    Account findAccountById(Integer accountId);
    Account findAccountByName(String name);
    void saveAccount(Account account);
    void updateAccount(Account account);
    void deleteAccount(Account account);
}
