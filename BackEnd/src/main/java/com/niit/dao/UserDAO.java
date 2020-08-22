package com.niit.dao;

import java.util.List;
import com.niit.model.UserDetail;

public interface UserDAO 
{
	public boolean addUser(UserDetail user);
	public boolean updateUser(UserDetail user);
	public boolean deleteUser(UserDetail user);
	public UserDetail getUserId(int userId) ;
	public List<UserDetail> listUser(); 
	
	
}
