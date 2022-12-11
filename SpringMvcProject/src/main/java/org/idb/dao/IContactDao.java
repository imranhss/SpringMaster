package org.idb.dao;

import java.util.List;

import org.idb.entity.Contact;


public interface IContactDao {

	
	public void save(Contact c);

	public void update(Contact c);

	public void delete(Contact c);

	public void delete(int contactId);

	public Contact findById(int contactId);

	public List<Contact> findByProperty(String propertyName, Object objectValue);

	public List<Contact> findAll();

	
}
