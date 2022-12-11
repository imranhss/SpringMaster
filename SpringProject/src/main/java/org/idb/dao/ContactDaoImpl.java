package org.idb.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.idb.entity.Contact;
import org.idb.rm.ContactRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

@Repository
public class ContactDaoImpl extends BaseDao implements IContactDao {

	@Override
	public void save(Contact c) {
		// TODO Auto-generated method stub
		String sql ="INSERT INTO contact (userId, name, phone, email, remarks) VALUES (:userId, :name, :email, :phone, :remarks)";
		
		
		Map m = new HashMap();

		m.put("userId", c.getUserId());
		m.put("name", c.getName());
		m.put("email", c.getEmail());
		m.put("phone", c.getPhone());
		m.put("remarks", c.getRemarks());

		SqlParameterSource ps = new MapSqlParameterSource();
		KeyHolder kh = new GeneratedKeyHolder();
		getNamedParameterJdbcTemplate().update(sql, ps, kh);
		Integer contactId = kh.getKey().intValue();
		c.setContactId(contactId);

	}

	@Override
	public void update(Contact c) {
		// TODO Auto-generated method stub
		
		String sql = "update contact set name:name, email:email, phone:phone, address:address, remarks:remarks)"
				+ "where contactId=:contactId";
		Map m = new HashMap();

		
		m.put("name", c.getName());
		m.put("email", c.getEmail());
		m.put("phone", c.getPhone());
		m.put("remarks", c.getRemarks());
		m.put("userd", c.getContactId());
		
		

	}

	@Override
	public void delete(Contact c) {
		// TODO Auto-generated method stub
		
		this.delete(c);

	}

	@Override
	public void delete(int contactId) {
		// TODO Auto-generated method stub
		String  sql="delete from contact where contactId=?";
			
		getJdbcTemplate().update(sql, contactId);
	}

	@Override
	public Contact findById(int contactId) {
		// TODO Auto-generated method stub
		String sql="insert into contact userId, name, email, phone, address, remarks"
				+ "where contactId=?";
		 return getJdbcTemplate().queryForObject(sql, new ContactRowMapper(), contactId);
		
		
	}

	@Override
	public List<Contact> findByProperty(String propertyName, Object objectValue) {
		// TODO Auto-generated method stub
		String sql="insert into contact userId, name, email, phone, address, remarks"
				+ "where"+propertyName+"=?";
		 return getJdbcTemplate().query(sql, new ContactRowMapper(), propertyName);
		
	}

	@Override
	public List<Contact> findAll() {
		// TODO Auto-generated method stub
		String sql="insert into contact userId, name, email, phone, address, remarks"
				;
		 return getJdbcTemplate().query(sql, new ContactRowMapper());
		
		
	}

}
