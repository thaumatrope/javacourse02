package com.example.application.MySQLDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
	private static Database db = new Database();
	private static final String dbURL = "jdbc:mysql://192.168.178.35:3306/peopleDAO"; 
	private Connection conn;
	
	public static Database instance() {
		return db;
	}
	
	private Database() {
		
	}
	
	public Connection getConnection() {
		return conn;
	}
	
	public void connect() throws SQLException {
		conn = DriverManager.getConnection(dbURL, "john", "hacker");
	}
	
	public void close() throws SQLException {
		conn.close();
	}

}
