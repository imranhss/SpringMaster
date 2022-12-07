package org.id.dao;

import java.util.List;

import org.idb.entity.User;

public interface IUserDao {
	public void save(User u);
	
	public void update(User u);
	
	public void delete(User u);
	
	public void delete(int userid);
	
	public User  findById(int userId);
	
	public List<User> findByProperty(String propertyName, Object objectValue);
	
	public List<User> findAll();
	
}
