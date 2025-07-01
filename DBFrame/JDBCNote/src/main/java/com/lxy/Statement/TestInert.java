package com.lxy.Statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TestInert {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3308/note";
        String username = "root";
        String password = "root";

        Connection connection = DriverManager.getConnection(url, username, password);

        Statement statement = connection.createStatement();
        String sql = "insert into test1 values(8,'usernameJDBCINSERT8' , 'passwordJDBCINSERT8')";
        int i = statement.executeUpdate(sql);
        System.out.println(i);

        statement.close();
    }
}
