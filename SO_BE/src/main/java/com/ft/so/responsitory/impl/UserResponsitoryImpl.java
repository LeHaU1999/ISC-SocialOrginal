package com.ft.so.responsitory.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ft.so.entity.Users;
import com.ft.so.responsitory.UserReponsitory;

@Repository
@Transactional(rollbackOn = Exception.class)
public class UserResponsitoryImpl implements UserReponsitory{

	@Autowired
	private SessionFactory sessionFactory;
	
	
	//xu ly lay danh sach user 
	public List<Users> getAllUser() {
		Session session = sessionFactory.getCurrentSession();
		try {
			Query<Users> query = session.createQuery("FROM Users", Users.class);
			List<Users> employees = query.getResultList();
			return employees;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ArrayList<Users>();
	}

	//xu ly lay thong tin user theo id
	public Users getUserById(int id) {
		Session session = sessionFactory.openSession();
		try {
			Query<Users> query = session.createQuery("FROM Users WHERE USER_ID = :id", Users.class);
			query.setParameter("id", id);
			List<Users> list = query.list();
			if (!list.isEmpty()) {
				return query.uniqueResult();
			}
		} catch (Exception e) {
			 e.printStackTrace();
		}
		return null ;
	}

	//xu ly lay thong tin user theo email
	public Users getUserByEmail(String email) {
		Session session = sessionFactory.openSession();
		try {
			Query<Users> query = session.createQuery("FROM Users WHERE email = :email", Users.class);
			query.setParameter("email", email);
			List<Users> list = query.list();
			if (!list.isEmpty()) {
				return query.uniqueResult();
			}

		} catch (Exception e) {
			 e.printStackTrace();
		}
		return null;
	}

	//xu ly lay thong tin user theo username
	public Users getUserByUserName(String userName) {
		Session session = sessionFactory.openSession();
		try {
			Query<Users> query = session.createQuery("FROM Users WHERE userName = :userName", Users.class);
			query.setParameter("userName", userName);
			List<Users> list = query.list();
			if (!list.isEmpty()) {
				return query.uniqueResult();
			}
		} catch (Exception e) {
			 e.printStackTrace();
		}
		return null;
	}
	
	//xu ly lay thong tin user theo so dien thoai 
	public Users getUserByPhoneNumber(String phoneNumber) {
		Session session = sessionFactory.openSession();
		try {
			Query<Users> query = session.createQuery("FROM Users WHERE SDT = :SDT", Users.class);
			query.setParameter("SDT", phoneNumber);
			List<Users> list = query.list();
			if (!list.isEmpty()) {
				return query.uniqueResult();
			}
		} catch (Exception e) {
			 e.printStackTrace();
		}
		return null;
	}

	//khoi tao function saveOrUpdate user => xuong tang service xu ly save va update
	public boolean saveOrUpdate(Users user) {
		Session session = sessionFactory.getCurrentSession();
		try 
		{
			session.saveOrUpdate(user);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean deleteUser(int id) {
		Session session = sessionFactory.getCurrentSession();
		try {
			Users entity = session.find(Users.class, id);
			session.load(Users.class, id);
			session.delete(entity);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	

	
}



























