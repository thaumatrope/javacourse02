package com.example.application.MySQLDAO;

import java.sql.SQLException;

@SuppressWarnings("serial")
public class DaoException extends RuntimeException{

	public DaoException(SQLException e) {
		super(e);
	}
}
