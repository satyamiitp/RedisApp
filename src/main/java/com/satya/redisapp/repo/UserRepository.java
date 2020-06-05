package com.satya.redisapp.repo;

import java.util.List;
import java.util.Map;

import com.satya.redisapp.bean.User;

public interface UserRepository {
	
	 void save(User user);
	 Map<String,User> findAll();
	 void delete(String id);
	 void update(User user);
	 User findById(String id);

}
