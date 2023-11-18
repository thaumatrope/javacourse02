package com.example.application.MySQLProperties;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Properties;

public class App 
{
    public static void main( String[] args ) throws ClassNotFoundException, SQLException
    {
    	
    	// Properties file src/main/resources
    	Properties props = new Properties();
    	try {
			props.load(App.class.getResourceAsStream("/config/db.properties"));
		} catch (IOException e) {
			e.printStackTrace();
			return;
		}
    	//Singleton 
    	var db = Database.instance();
               
        try{
        	db.connect(props);
        }catch (SQLException e) {
        	System.out.println("Cannot connect to database.");
        	return;
        }
        
        System.out.println("Connected");
        
        UserDao userDao = new UserDaoImpl();
        //userDao.save(new User("Sun"));
        //userDao.save(new User("Venus"));
        userDao.getAll().forEach(System.out::println);
        var user = userDao.findById(1);
        
        if(user.isEmpty()) {
        	System.out.println("Retrieved User: no retrievable user found.");
        }else {
        	System.out.println("Retrieved User: " + user.get());
        }
        if(user.isPresent())
        	//userDao.delete(user.get());
        	userDao.update(new User(1, "Muschi"));
        	
        	
        
        userDao.getAll().forEach(System.out::println);
        
        
        try{
        	db.close();
        }catch (SQLException e) {
        	System.out.println("Cannot close database connection.");
        }
      
        		
        
    }
}
