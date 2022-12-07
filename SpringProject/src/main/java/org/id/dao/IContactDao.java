package org.id.dao;

import java.util.List;

import org.idb.entity.Contact;
import org.idb.entity.User;

public interface IContactDao {
	
	public void save(Contact c);
	
	public void update(Contact c);
	
	public void delete(Contact c);
	
	public Contact delete(int contactId);
	
	public Contact   findById(int contactId);
	
	public List<Contact> findByProperty(String propertyName, Object objectValue);
	
	public List<Contact> findAll();
	
	
	
	
}
