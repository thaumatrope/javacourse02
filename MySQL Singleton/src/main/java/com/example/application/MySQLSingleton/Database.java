package com.example.application.MySQLSingleton;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
	private static Database db = new Database();
	private static final String dbURL = "jdbc:mysql://192.168.178.35:3306/people2"; 
	private Connection conn;
	
	public static Database instance() {
		return db;
	}
	
	private Database() {
		
	}
	
	public void connect() throws SQLException {
		conn = DriverManager.getConnection(dbURL, "john", "hacker");
	}
	
	public void close() throws SQLException {
		conn.close();
	}

}
