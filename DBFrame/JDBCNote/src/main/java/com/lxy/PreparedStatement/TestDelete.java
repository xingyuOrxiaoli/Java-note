package com.lxy.PreparedStatement;

import java.sql.*;

public class TestDelete {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3308/note";
        String username = "root";
        String password = "root";

        Connection connection = DriverManager.getConnection(url, username, password);


        String sql = "delete from test1 where id =  ?" ;

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, 8);
        int i = preparedStatement.executeUpdate();
        System.out.println(i);


        preparedStatement.close();
        connection.close();
    }
}
