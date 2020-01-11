package com.niit.backend;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.junit4.SpringRunner;

import com.niit.config.AppConfig;
import com.niit.service.*;
import com.niit.model.User;
import com.niit.service.UserService;

@RunWith(SpringRunner.class)
@SpringJUnitConfig(classes=AppConfig.class)

public class UserTest 
{
	@Autowired
	UserService userService;
	
	@Test
	public void addUser()
	{
		
			User u=new User();
			u.setUsername("Sagar123");
			u.setEmail("sagar@gmail.com");
			u.setAuthority("admin");
			u.setStatus(true);
		
			assertEquals(true, userService.addUser(u));
		
	}
	
	@Test
	@Ignore
	public void deleteUser()
	{
		assertEquals(true, userService.deleteUser(12));
	}
	
	@Test
	@Ignore
	public void updateUser()
	{
		User user=userService.displayUserById(14);
		user.setUsername("Sameer123");
		assertEquals(true, userService.updateUser(user));
	}
	
	@Test
	@Ignore
	public void displayUsers()
	{
		assertNotNull(userService.displayUsers());
	}
	
	
	@Test
	@Ignore
	public void displayUserById()
	{
		assertNotNull(userService.displayUserById(80));
	}
}
