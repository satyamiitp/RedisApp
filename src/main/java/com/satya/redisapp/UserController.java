package com.satya.redisapp;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.satya.redisapp.bean.User;
import com.satya.redisapp.repo.UserRepository;

@RestController
@RequestMapping("/rest/user")
public class UserController {
	
	
	@Autowired UserRepository  userRepository;
	
	@GetMapping("add/{add}/{name}")
	public User add(@PathVariable("id") final String id,@PathVariable("name") final String name)
	{
		 userRepository.save(new User(id,name,20000L));
		 
		 return userRepository.findById(id);
		 
		
	}
	
	
	@GetMapping("update/{add}/{name}")
	public User update(@PathVariable("id") final String id,@PathVariable("name") final String name)
	{
		 userRepository.save(new User(id,name,25000L));
		 
		 return userRepository.findById(id);
		 
		
	}
	
	
	@GetMapping("all/")
	public Map<String,User> findAll()
	{
		return userRepository.findAll();
		 
	}
	
	

}
