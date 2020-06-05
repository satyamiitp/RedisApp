package com.satya.redisapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

import com.satya.redisapp.bean.User;


@SpringBootApplication
public class RedisappApplication {
	
	
	@Bean
	
	JedisConnectionFactory   jedisConnectionFactory()
	{
		return new JedisConnectionFactory();
	}

	public static void main(String[] args) {
		SpringApplication.run(RedisappApplication.class, args);
	}
	
	@Bean
	RedisTemplate<String, User> getRedisTemplate()
	{
		RedisTemplate<String, User> redisTemplate= new RedisTemplate<String, User>();
		redisTemplate.setConnectionFactory(jedisConnectionFactory());
		return  redisTemplate;
		
	}

}
