package com.niit.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import com.niit.dao.UserDAO;
import com.niit.daoimpl.UserDAOImpl;
import com.niit.model.User;


public class UserTest 
{
	UserDAO udi=new UserDAOImpl();
	
	@Test
	@Ignore
	public void addUser()
	{
		User u=new User();
		u.setUsername("Sagar123");
		u.setEmail("sagar@gmail.com");
		u.setAuthority("admin");
		u.setStatus(true);
		
		assertEquals(true, udi.addUser(u));
	}
	
	@Test
	@Ignore
	public void deleteUser()
	{
		assertEquals(true, udi.deleteUser(12));
	}
	
	@Test
	@Ignore
	public void updateUser()
	{
		User user=udi.displayUserById(8);
		user.setUsername("sagar");
		assertEquals(true, udi.updateUser(user));
	}
	
	@Test
	@Ignore
	public void displayUsers()
	{
		assertNotNull(udi.displayUsers());
	}
	
	
	@Test
	public void displayUserById()
	{
		assertNotNull(udi.displayUserById(80));
	}
}
