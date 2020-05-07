package com.example.teacher.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class Contant {

    public static Connection getconnection() throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn=DriverManager.getConnection("jdbc:mysql://192.168.0.4/user","root","123456");
        return conn;
    }

    public static void DBclose(ResultSet resultSet, Statement statement,Connection connection){
        try {
            if(resultSet!=null){
            resultSet.close();
        }

        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            if(statement!=null){
                statement.close();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            if(connection!=null){
                connection.close();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
