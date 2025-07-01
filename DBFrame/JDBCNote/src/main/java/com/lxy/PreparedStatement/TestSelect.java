package com.lxy.PreparedStatement;

import java.sql.*;

public class TestSelect {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3308/note";
        String username = "root";
        String password = "root";

        Connection connection = DriverManager.getConnection(url, username, password);

        String sql = "select * from test1 where id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, 8);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("username");
            String pw = resultSet.getString("password");
            System.out.println("id:" + id + "\tusername:" + name +"\tpassword:" + pw);

        }

        resultSet.close();
        preparedStatement.close();
        connection.close();
    }
}
