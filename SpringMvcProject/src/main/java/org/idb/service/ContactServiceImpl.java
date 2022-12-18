package org.idb.service;

import java.util.List;

import org.idb.dao.BaseDao;
import org.idb.dao.IContactDao;
import org.idb.entity.Contact;
import org.idb.rm.ContactRowMapper;
import org.idb.util.StringUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactServiceImpl extends BaseDao implements IContactService{
	
	@Autowired
	IContactDao dao;
	
	@Override
	public void save(Contact c) {
		// TODO Auto-generated method stub
		dao.save(c);
	}
	

	@Override
	public void update(Contact c) {
		// TODO Auto-generated method stub
		dao.update(c);
	}

	@Override
	public void delete(int contactId) {
		// TODO Auto-generated method stub
		dao.delete(contactId);
	}

	
	@Override
	public void delete(Integer[] contactIds) {
		// TODO Auto-generated method stub
		String ids=StringUtility.toCommaSeparatedString(contactIds);
		String sql="delete from contact where contactId in("+ids+")";
		getJdbcTemplate().update(sql);
		
	}

	@Override
	public List<Contact> findUserContact(int userId) {
		// TODO Auto-generated method stub
		
		return dao.findByProperty("userId", userId);
	}

	@Override
	public List<Contact> findUserContact(int userId, String txt) {
		// TODO Auto-generated method stub
		String sql="select userId, name, email, phone,  remarks from contact"
				+ "where userId=? and (name like'%"+txt+"%' "
						+ "or phone like'%"+txt+"%' or email like'%"+txt+"%'  "
								+ "or remarks like'%"+txt+"%')";
		 return getJdbcTemplate().query(sql, new ContactRowMapper(), userId);

	}
	
	

}
