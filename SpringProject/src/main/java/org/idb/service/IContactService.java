package org.idb.service;

import java.util.List;

import org.idb.entity.Contact;

public interface IContactService {

	public void save(Contact c);

	public void update(Contact c);

	public void delete(int contactId);

	public void delete(Integer[] contactIds);

	//this methjod user contact logged uder
	
	public List<Contact> findUserContact(Integer userId);

	// search user by text
	public List<Contact> findUserContact(int userId, String txt);

}
