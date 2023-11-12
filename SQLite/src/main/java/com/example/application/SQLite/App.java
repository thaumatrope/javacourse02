package com.example.application.SQLite;

import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws ClassNotFoundException, SQLException
    {
        Class.forName("org.sqlite.JDBC");
        
        String dbURL = "jdbc:sqlite:people.db"; 
        var conn = DriverManager.getConnection(dbURL);
        
        //System.out.println(conn);
        
        var stmt = conn.createStatement();
        
        var sql1 = "drop table user";
        var sql2 = "create table user (id integer primary key, name text not null)";
        stmt.execute(sql1);
        stmt.execute(sql2);
        
        stmt.close();
        		
        conn.close();
    }
}
