package com.xliu.utils;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author liuxin
 * @version 1.0
 * @date 2020/3/18 16:38
 */
public class ConnectUtils {

    private DataSource dataSource;

    private ThreadLocal<Connection> tl = new ThreadLocal<>();

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public Connection getConnect(){
        Connection connection = tl.get();
        if(connection==null){
            try {
                connection = dataSource.getConnection();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            tl.set(connection);
        }
        return connection;
    }

    public void removeConnection(){
        tl.remove();
    }

}
