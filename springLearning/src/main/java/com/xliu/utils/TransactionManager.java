package com.xliu.utils;

import com.mchange.v1.db.sql.ConnectionUtils;

import java.sql.SQLException;

/**
 * @author liuxin
 * @version 1.0
 * @date 2020/3/18 16:42
 */
public class TransactionManager {

    private ConnectUtils connectUtils;

    public void setConnectUtils(ConnectUtils connectUtils) {
        this.connectUtils = connectUtils;
    }

    public void beginTransaction(){
        try {
            System.out.println("关闭自动提交事务");
            connectUtils.getConnect().setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void commitTransaction(){
        try {
            System.out.println("提交事务");
            connectUtils.getConnect().commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void roolbackTransaction(){
        try {
            System.out.println("回滚事务");
            connectUtils.getConnect().rollback();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void releaseTransaction(){
        try {
            System.out.println("归还连接");
            connectUtils.getConnect().close();
            connectUtils.removeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
