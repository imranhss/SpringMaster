package org.idb.service;

import java.util.List;

import org.idb.dao.BaseDao;
import org.idb.dao.IUserDao;
import org.idb.entity.User;
import org.idb.exception.UserBlockException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends BaseDao implements IUserService{

	@Autowired
	private IUserDao dao;
	
	@Override
	public void userRegiter(User u) {
		// TODO Auto-generated method stub
		this.dao.save(u);		
		
	}

	@Override
	public User login(String loginName, String password) throws UserBlockException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> getUserList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void chageLoginStatus(int userId, int loginStatus) {
		// TODO Auto-generated method stub
		
	}

	
	
	
}
