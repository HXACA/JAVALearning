package com.xliu.jdbc;

import java.sql.*;

/**
 * @author liuxin
 * @version 1.0
 * @date 2020/3/18 13:24
 */
public class JdbcDemo1 {
    public static void main(String[] args) throws SQLException {
        DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/spring","root","root");
        PreparedStatement pstm = conn.prepareStatement("select * from account");
        ResultSet rs = pstm.executeQuery();
        while(rs.next()){
            System.out.println(rs.getString("name"));
        }
        rs.close();
        pstm.close();
        conn.close();
    }
}
