package com.example.teacher.database;


import java.sql.Connection;
import java.sql.Statement;

public class TeacherData{


    public void Tinsert(){
        Connection connection = null;
        Statement statement = null;
        try {
            connection=Contant.getconnection();
            statement=connection.createStatement();
            String sql="";
           statement.execute(sql);

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            Contant.DBclose(null,statement,connection);
        }



    }

}

