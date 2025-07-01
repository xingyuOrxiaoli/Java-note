package com.lxy.PreparedStatement;

import java.sql.*;

public class TestUpdate {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3308/note";
        String username = "root";
        String password = "root";

        Connection connection = DriverManager.getConnection(url, username, password);


        String sql = "update test1 set username = 'JDBCPreparedStatementUPDATE8' where id =  ?" ;

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, 8);
        int i = preparedStatement.executeUpdate();
        System.out.println(i);


        preparedStatement.close();
        connection.close();
    }
}
