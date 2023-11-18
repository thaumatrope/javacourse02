package com.example.application.MySQLProperties;

import java.util.List;
import java.util.Optional;

public interface Dao<T> {
	
	
	//CRUD
	void save (T t);
	
	Optional<T> findById(int id);
	
	void update(T t);
	
	void delete (T t);
	
	// comfort function
	List<T> getAll();
	
	

}
