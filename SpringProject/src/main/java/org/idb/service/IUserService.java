package org.idb.service;

import java.util.List;

import org.idb.entity.User;
import org.idb.exception.UserBlockException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


public interface IUserService {
	
	public static final int LOGIN_STATUS_ACTIVE=1; 
	public static final int LOGIN_STATUS_BLOCK=2; 
	
	public static final int ROLE_ADMIN=1; 
	public static final int ROLE_USER=2; 
	
	public void userRegiter(User u);
	
	public User login(String loginName, String password) throws UserBlockException;
	
	public List<User> getUserList();
	
	// 1 is for Active and 2 will for block
	public void chageLoginStatus(int userId, int loginStatus);
	
}
