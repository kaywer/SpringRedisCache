package com.geekarms.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.geekarms.entity.User;

import java.util.List;


@Repository
public class UserDao {
	@Autowired
	private SessionFactory sessionFactory;
	
	public List<User> getAllUser(){
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("From User", User.class).list();
	}

	public User addUser(User user){
		Session session = sessionFactory.getCurrentSession();
		session.save(user);
		return user;
	}

	public User findById(Long id){
		Session session = sessionFactory.getCurrentSession();
		return session.find(User.class, id);
	}

	public User findByLogin(String login){
		Session session = sessionFactory.getCurrentSession();
		String hql = "FROM User u WHERE u.login=:login";
		return (User) session.createQuery(hql).setParameter("login", login).uniqueResult();
	}

	public User update(User user){
		Session session = sessionFactory.getCurrentSession();
		session.update(user);
		return user;
	}
}
