package com.example.application.MySQLPropertiesProfiles;

import java.io.IOException;
import java.util.Properties;

public class Profile {
	
	public static Properties getProperties(String name) {		
		
		// Properties file src/main/resources
    	Properties props = new Properties();
    	//Profile
    	String env = System.getProperty("env");
    	
    	if (env == null){
    		env = "dev";
    	}   	
    	
    	String propertiesfile = String.format("/config/%s.%s.properties", name, env);
    	System.out.println(propertiesfile);
    	try {
			props.load(App.class.getResourceAsStream(propertiesfile));
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("Cannot load properties file: " + propertiesfile);
		}
		return props;
	}

}
