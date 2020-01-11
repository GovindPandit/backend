package com.niit.daoimpl;

import java.util.List;

import javax.persistence.Query;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.dao.UserDAO;
import com.niit.model.User;
import com.niit.util.HibernateUtil;

@Repository("userDAO")
@Transactional
public class UserDAOImpl implements UserDAO 
{
	
	@Autowired
	SessionFactory sessionFactory;
	
	public boolean addUser(User user) 
	{
		try
		{
			Session session=sessionFactory.openSession();
			Transaction tx=session.beginTransaction();
			session.save(user);
			tx.commit();
		}
		catch (Exception e) 
		{
			System.out.println(e);
		}
		return true;
	}

	public boolean deleteUser(int userid) 
	{
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		
		User u=new User();
		u.setUserid(userid);
		session.delete(u);
		tx.commit();
		return true;
	}

	public boolean updateUser(User user) 
	{
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		session.update(user);
		tx.commit();
		return true;
	}

	public List<User> displayUsers() 
	{
		Session session=sessionFactory.openSession();
		return session.createQuery("from com.niit.model.User").list();
	}

	public User displayUserById(int userid) 
	{
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from com.niit.model.User where userid=: uid");
		query.setParameter("uid", userid);
		return (User)query.getResultList().get(0);
	}

	public User displayUserByName(String username) 
	{
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from com.niit.model.User where userid=: uname");
		query.setParameter("uname", username);
		return (User)query.getResultList().get(0);
	}

}
