package com.revature.repository;

import java.util.List;

import org.hibernate.Session;

import com.revature.model.User;
import com.revature.util.HibernateUtil;

public class UserDao {
	public List<User> getUsers() {
		Session session = HibernateUtil.getSession();
		return session.createQuery("from User").list();
	}
}