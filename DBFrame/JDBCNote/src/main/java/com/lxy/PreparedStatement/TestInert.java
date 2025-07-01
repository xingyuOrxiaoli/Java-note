package com.lxy.PreparedStatement;

import java.sql.*;

public class TestInert {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3308/note";
        String username = "root";
        String password = "root";

        Connection connection = DriverManager.getConnection(url, username, password);


        String sql = "insert into test1 values(?,?, ?)";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, 8);
        preparedStatement.setString(2, "usernameJDBCINSERT8");
        preparedStatement.setString(3, "passwordJDBCINSERT8");
        int i = preparedStatement.executeUpdate();
        System.out.println(i);


        preparedStatement.close();
        connection.close();
    }
}
