package com.lxy.Statement;

import java.sql.*;

public class TestSelect {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3308/note";
        String username = "root";
        String password = "root";

        Connection connection = DriverManager.getConnection(url, username, password);

        Statement statement = connection.createStatement();
        String sql = "select * from test1";
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("username");
            String pw = resultSet.getString("password");
            System.out.println("id:" + id + "\tusername:" + name +"\tpassword:" + pw);

        }

        resultSet.close();
        statement.close();
        connection.close();
    }
}
