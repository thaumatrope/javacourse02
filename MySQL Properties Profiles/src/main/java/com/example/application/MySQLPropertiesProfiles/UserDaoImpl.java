package com.example.application.MySQLPropertiesProfiles;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserDaoImpl implements UserDao{

	@Override
	public void save(User u) {
		// TODO Auto-generated method stub
		var conn = Database.instance().getConnection();
		
		try{
			var stmt = conn.prepareStatement("insert into user (name) values (?)");
			stmt.setString(1, u.getName());
			stmt.executeUpdate();
			stmt.close();
			
		}catch(SQLException e) {
			throw new DaoException(e);
		}
		
		
	}

	@Override
	public Optional<User> findById(int id) {
		// TODO Auto-generated method stub
		User tmpUser = null;
		var conn = Database.instance().getConnection();
		
		try{
			var stmt = conn.prepareStatement("select id, name from user where id=?");
			stmt.setInt(1, id);
			var rs = stmt.executeQuery();			
			
			while(rs.next()) {
				tmpUser = new User(rs.getInt(1), rs.getString(2));		
			}	
			stmt.close();
			
			
		}catch(SQLException e) {
			throw new DaoException(e);
		}
		
		if(tmpUser == null) {
			return Optional.empty();
		}else {
			return Optional.of(tmpUser);
		}
		
		
	}

	@Override
	public void update(User u) {
		// TODO Auto-generated method stub
		var conn = Database.instance().getConnection();
		
		try{
			var stmt = conn.prepareStatement("update user set name=? where id=?");
			stmt.setString(1, u.getName());
			stmt.setInt(2, u.getId());				
			
			stmt.executeUpdate();			
			
			stmt.close();
			
			
		}catch(SQLException e) {
			throw new DaoException(e);
		}	
	}

	@Override
	public void delete(User u) {
		// TODO Auto-generated method stub
		var conn = Database.instance().getConnection();
		
		try{
			var stmt = conn.prepareStatement("delete from user where id=?");
			stmt.setInt(1, u.getId());
			stmt.executeUpdate();			
			
			stmt.close();
			
			
		}catch(SQLException e) {
			throw new DaoException(e);
		}		
		
	}

	@Override
	public List<User> getAll() {
		// TODO Auto-generated method stub
		List<User> users = new ArrayList<>();
		
		var conn = Database.instance().getConnection();
		
		try{
			var stmt = conn.createStatement();

			var rs = stmt.executeQuery("select id, name from user");
			
			
			while(rs.next()) {
				users.add(new User(rs.getInt(1), rs.getString(2)));		
			}	
			stmt.close();
			
		}catch(SQLException e) {
			throw new DaoException(e);
		}
		
		return users;


	}

}
