package com.example.application.MySQLSingleton;

import java.sql.DriverManager;
import java.sql.SQLException;

public class App 
{
    public static void main( String[] args ) throws ClassNotFoundException, SQLException
    {
        int[] ids = {0,1,2,3};
        String[] names = {"Sue", "Bob", "Suzie", "Frankie"};
        
        Class.forName("com.mysql.cj.jdbc.Driver");
        
        //Singleton
        var db = Database.instance();
        
        
        try{
        	db.connect();
        }catch (SQLException e) {
        	System.out.println("Cannot connect to database.");
        }
        
        System.out.println("Connected");
        
        
        try{
        	db.close();
        }catch (SQLException e) {
        	System.out.println("Cannot close database connection.");
        }
      
        		
        
    }
}
