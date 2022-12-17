package org.idb.service;

import java.util.List;

import org.idb.entity.Contact;

public interface IContactService {
	
	public void save(Contact c);

	public void update(Contact c);

	public void delete(int contactId);

	//Delete more than one contact at a time
	public void delete(Integer[] contactIds);

	//this methhod user contact logged user	
	public List<Contact> findUserContact(int userId);

	// search user by text
	public List<Contact> findUserContact(int userId, String txt);

}
