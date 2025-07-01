package com.lxy.PreparedStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TestTransaction {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3308/note";
        String username = "root";
        String password = "root";

        Connection connection = DriverManager.getConnection(url, username, password);

        connection.setAutoCommit(false);
        try {
            String sql = "update test1 set username = ? where id =  ?" ;
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, "第一次交换");
            preparedStatement.setInt(2, 1);
            preparedStatement.executeUpdate();

            int i = 1 / 0 ;

            preparedStatement.setString(1, "第二次交换");
            preparedStatement.setInt(2, 2);
            preparedStatement.executeUpdate();

            connection.commit();
            preparedStatement.close();
        }catch (SQLException e) {
            System.out.println("回滚");
            connection.rollback(); // 回滚
        }
        // 交换用户名

        connection.close();
    }
}
