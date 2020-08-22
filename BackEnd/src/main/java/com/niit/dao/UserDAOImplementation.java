package com.niit.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.model.UserDetail;

@Repository("userDAO")
@Transactional
public class UserDAOImplementation implements UserDAO
{
	@Autowired
	SessionFactory sessionfactory;
	
	@Override
	public boolean addUser(UserDetail user)
	{   
		try
		{
			sessionfactory.getCurrentSession().save(user);
			return true;
		}
		
		catch(Exception e)
		{
		 return false;
		}
	}

	
	@Override
	public boolean updateUser(UserDetail user)
	{
		try 
		{
		  sessionfactory.getCurrentSession().update(user);
		  return true;
		}

		catch(Exception e)
		{
		return false;
		}
	}

	@Override
	public boolean deleteUser(UserDetail user) 
	{
		try 
		{
		  sessionfactory.getCurrentSession().delete(user);
		  return true;
		}

		catch(Exception e)
		{
		return false;
		}
	}

	@Override
	public UserDetail getUserId(int userId)
	{
		Session session=sessionfactory.openSession();
		UserDetail user=(UserDetail)session.get(UserDetail.class,userId);
		session.close();
		return user;
	}

	@Override
	public List<UserDetail> listUser()
	{
		Session session=sessionfactory.openSession();
		Query query=session.createQuery("from UserDetail");
		List<UserDetail> listuser=query.list();
		session.close();
		return listuser;
		
	}

}
