package com.satya.redisapp.bean;

import org.springframework.boot.context.properties.ConstructorBinding;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class User {
	
	
	 String id ;
     String name;
     Long Salary;
     
     
     public User(String id, String name, Long salary) {
 		super();
 		this.id = id;
 		this.name = name;
 		Salary = salary;
 	}

}
