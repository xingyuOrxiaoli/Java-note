package com.lxy.Statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TestTransaction {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3308/note";
        String username = "root";
        String password = "root";

        Connection connection = DriverManager.getConnection(url, username, password);
        Statement statement = connection.createStatement();

        connection.setAutoCommit(false);
        try {
            String sql = "update test1 set username = '第三次交换' where id =  3";
            statement.executeUpdate(sql);

            int i = 1 / 0 ;
            sql = "update test1 set username = '第四次交换' where id =  4";
            statement.executeUpdate(sql);
            connection.commit(); // 两个都提交了才提交
        }catch (SQLException e) {
            System.out.println("回滚");
            connection.rollback(); // 回滚
        }


        statement.close();
        connection.close();
    }
}
