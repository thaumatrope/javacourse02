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
        int[] ids = {0,1,2};
        String[] names = {"Sue", "Bob", "Suzie"};
        
        Class.forName("org.sqlite.JDBC");
        
        String dbURL = "jdbc:sqlite:people.db"; 
        var conn = DriverManager.getConnection(dbURL);
        
        //System.out.println(conn);
        
        var stmt = conn.createStatement();
        
        var sql1 = "drop table if exists user";
        var sql2 = "create table user (id integer primary key, name text not null)";
        stmt.execute(sql1);
        stmt.execute(sql2);
        
        // normal statements
//        var sql3 = "insert into user(id, name) values (0, 'Bob')";
//        stmt.execute(sql3);
//        var sql4 = "insert into user(id, name) values (1, 'Mary')";
//        stmt.execute(sql4);
        
        //prepared statements        
        var sql3 = "insert into user(id, name) values (?,?)";
        var insertStmt = conn.prepareStatement(sql3);
        for(int i = 0; i < ids.length; i++) {
        	// columns start numbering with 1 !! not 0
        	insertStmt.setInt(1, ids[i]);
        	insertStmt.setString(2, names[i]);
        	insertStmt.executeUpdate();
        }
        
        var sql5 = "select id, name from user";
        var rs = stmt.executeQuery(sql5);
        
        while(rs.next()) {
        	int id = rs.getInt("id");
        	String name = rs.getString("name");
        	
        	System.out.println("ID: " + id + " / Name: " + name);
        }
        
        stmt.close();
        		
        conn.close();
    }
}
