package com.niit.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import java.util.List;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.niit.dao.UserDAO;
import com.niit.model.UserDetail;

public class UserDAOTest
{

static UserDAO userdao;
	
	@BeforeClass
	public static void initialize()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();		
		
		context.scan("com.niit");
	    context.refresh();
	    
	    userdao=(UserDAO)context.getBean("userDAO");
				
	}
	
	@Ignore
	@Test
	public void addUserTest()
	{
		UserDetail user=new UserDetail();
		user.setUsername("Deva");
		user.setPassword("Deva@12345");
		user.setCustomerName("Sairam");
		user.setMobileno("1234567890");
		user.setMailid("Kaarthik@gmail.com");
		user.setRole("ROLE_ADMIN");
		user.setEnabled("on");
		assertTrue("problem in Addding User!",userdao.addUser(user));
		
	}
	
	
	@Ignore
	@Test
	public void updateUserTest()
	{
		UserDetail user=userdao.getUserId(46);
		user.setUsername("upuser");
		user.setPassword("uppassword");
		user.setCustomerName("upcustomer");
		user.setMobileno("up1234567890");
		user.setMailid("update@gmail.com");
		user.setRole("upbusiness");
		user.setEnabled("upOn");
		assertTrue("Problem in Updating!",userdao.updateUser(user));
	
	}
	
	
	@Ignore
	@Test
	public void deleteUserTest()
	{
		UserDetail user=userdao.getUserId(46);
		assertTrue("Problem in Deleting!",userdao.deleteUser(user));
		
	}
	 
	
	@Ignore
	@Test
	public void listUser()
	{
		List<UserDetail> listuser=userdao.listUser();
		assertNotNull("Problem in Listing!",listuser);
		
		for(UserDetail u:listuser)
		{
            System.out.println(u.getUserId()+"::::::"+u.getUsername()+"::::::"+u.getPassword()+"::::::"+u.getCustomerName()+"::::::"+u.getMobileno()+"::::::"+u.getMailid()+"::::::"+u.getRole()+"::::::"+u.getEnabled());
		}	
	}
	
}