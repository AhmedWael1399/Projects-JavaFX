package com.example.login;

import java.sql.Connection;
import java.sql.DriverManager;

public abstract class connectingToDatabase {
    public static Connection getConnection ()
    {
        try
        {
           // Class.forName("com.mysql.jdbc.Driver");
            String url ="jdbc:mysql://localhost:3307 /";
            String databaseName = "loginandsignup";
            String userName = "root";
            String passWord = "rootpassword";
            Connection conn = DriverManager.getConnection(url+databaseName,userName, passWord);

            System.out.println("Connected successfully");
            return conn ;
        }
        catch (Exception e)
        {
            System.out.println("Cannot connect t the database");
            e.printStackTrace();
            return null;
        }
}

}


