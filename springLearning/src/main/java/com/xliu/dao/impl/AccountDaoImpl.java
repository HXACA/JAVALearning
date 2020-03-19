package com.xliu.dao.impl;

import com.xliu.bean.Account;
import com.xliu.dao.AccountDao;
import com.xliu.utils.ConnectUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

/**
 * @author liuxin
 * @version 1.0
 * @date 2020/3/18 14:00
 */
public class AccountDaoImpl implements AccountDao {

    private QueryRunner runner;

    private ConnectUtils connectUtils;

    public void setConnectUtils(ConnectUtils connectUtils) {
        this.connectUtils = connectUtils;
    }

    public void setRunner(QueryRunner runner) {
        this.runner = runner;
    }

    public List<Account> findAllAccount() {
        try {
            return runner.query(connectUtils.getConnect(),"select * from account",new BeanListHandler<Account>(Account.class));
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public Account findAccountById(Integer accountId) {
        try {
            return runner.query(connectUtils.getConnect(),"select * from account where id=?",new BeanHandler<Account>(Account.class),accountId);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    public Account findAccountByName(String name) {
        try {
            List<Account> query = runner.query(connectUtils.getConnect(),"select * from account where name=?", new BeanListHandler<Account>(Account.class), name);
            if(query.size() == 1)
                return query.get(0);
            else if(query == null || query.size() == 0)
                return null;
            throw new RuntimeException("结果不唯一");
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public void saveAccount(Account account) {
        try {
            runner.update(connectUtils.getConnect(),"insert into account(name,money) values(?,?)",account.getName(),account.getMoney());
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public void updateAccount(Account account) {
        try {
            runner.update(connectUtils.getConnect(),"update  account set name=? ,money=? where id=?",account.getName(),account.getMoney(),account.getId());
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public void deleteAccount(Account account) {
        try {
            runner.update(connectUtils.getConnect(),"delete from account where id=?",account.getId());
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

}
