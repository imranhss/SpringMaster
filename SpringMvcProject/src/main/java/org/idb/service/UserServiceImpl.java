package org.idb.service;

import java.util.List;

import org.idb.dao.BaseDao;
import org.idb.dao.IUserDao;
import org.idb.entity.User;
import org.idb.exception.UserBlockException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends BaseDao implements IUserService{

	@Autowired
	IUserDao dao;
	
	@Override
	public void userRegister(User u) {
		// TODO Auto-generated method stub
		dao.save(u);		
	}

	
	@Override
	public User login(String loginName, String password) throws UserBlockException {
		// TODO Auto-generated method stub
		String sql="select * from user where loginName=? and password=?";
		
		return null;
	}

	@Override
	public List<User> getUserList() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	public void changeLoginStatus(int userId, int loginStatus) {
		// TODO Auto-generated method stub
		
	}

	
	
}
