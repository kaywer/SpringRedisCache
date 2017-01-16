package com.geekarms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.geekarms.dao.UserDao;
import com.geekarms.entity.User;

import java.util.List;

@Service
@Transactional
public class UserService {
	@Autowired
	private UserDao userDao;

	@Cacheable(value = "user", key = "'getAllUser'")
	public List<User> getAllUser(){
		return userDao.getAllUser();
	}


	@Cacheable(value = "user", key = "'id' + #id")
	public User findById(Long id){
		return userDao.findById(id);
	}

	@Cacheable(value = "user", key = "'login' + #login")
	public User findByLogin(String login){
		return userDao.findByLogin(login);
	}

	@Caching(
			put = {
					@CachePut(value = "user", key = "'login' + #login")
			},
			evict = @CacheEvict(value = "user", key = "'getAllUser'")
	)
	public User addUser(String login){
		User user = new User();
		user.setLogin(login);
		user.setPassword(login);
		user.setUserName(login);
		return userDao.addUser(user);
	}

	@Caching(
		put = {
			@CachePut(value = "user", key = "'id' + #id"),
			@CachePut(value = "user", key = "'login' + #login")
		},
		evict = @CacheEvict(value = "user", key = "'getAllUser'")
	)
	public User update(Long id, String login){
		User user = userDao.findById(id);
		user.setLogin(login);
		return userDao.update(user);
	}

}
