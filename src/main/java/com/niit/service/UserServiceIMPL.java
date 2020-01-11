package com.niit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.niit.dao.UserDAO;
import com.niit.model.User;

@Service
public class UserServiceIMPL implements UserService 
{

	@Autowired
	UserDAO userDAO;
	
	public boolean addUser(User user) 
	{
		userDAO.addUser(user); 
		return true;
	}

	public boolean deleteUser(int userid) 
	{
		userDAO.deleteUser(userid); 
		return true;
	}

	public boolean updateUser(User user)
	{
		userDAO.updateUser(user); 
		return true;
	}

	public List<User> displayUsers() 
	{
		return userDAO.displayUsers();
	}

	public User displayUserById(int userid) 
	{
		return userDAO.displayUserById(userid);
	}

	public User displayUserByName(String username)
	{
		return userDAO.displayUserByName(username);
	}
	
}
