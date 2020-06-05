package com.satya.redisapp.repo;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import com.satya.redisapp.bean.User;

@Repository
public class UserRepositoryImpl implements UserRepository {

	@Autowired
	RedisTemplate<String, User> redisTemplate;
	
	@Autowired
	HashOperations hashOperations;

	private Object object;
	
	
	
	
	
	
	public UserRepositoryImpl(RedisTemplate<String, User> redisTemplate) {
		super();
		this.redisTemplate = redisTemplate;
		hashOperations=redisTemplate.opsForHash();
	}

	@Override
	public void save(User user) {
		
		hashOperations.put("USER", user.getId(), user);
	}

	@Override
	public Map<String,User> findAll() {

		return hashOperations.entries("USER");
	}

	@Override
	public void delete(String id) {
		hashOperations.delete("USER", id);
	}

	@Override
	public void update(User user) {
		save(user);

	}

	@Override
	public User findById(String id) {
		return (User) (object = hashOperations.get("USER", id));

	}

}
