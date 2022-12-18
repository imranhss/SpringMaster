package org.idb.daoimpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.idb.dao.BaseDao;
import org.idb.dao.IContactDao;
import org.idb.entity.Contact;
import org.idb.rm.ContactRowMapper;
import org.idb.rm.UserRowMapper;
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
		String sql = "insert into contact(userId, name, email, phone, remarks)"
				+ "values(:userId, :name, :email, :phone, :remarks)";
		Map m = new HashMap();

		m.put("userId", c.getUserId());
		m.put("name", c.getName());
		m.put("email", c.getEmail());
		m.put("phone", c.getPhone());
		m.put("remarks", c.getRemarks());

		KeyHolder kh = new GeneratedKeyHolder();

		SqlParameterSource ps = new MapSqlParameterSource(m);

		getNamedParameterJdbcTemplate().update(sql, ps, kh);

		Integer contactId = kh.getKey().intValue();

		c.setContactId(contactId);

	}

	@Override
	public void update(Contact c) {
		// TODO Auto-generated method stub
		String sql="update contact set name=:name, phone=:phone, email=:email, remarks=:remarks "
				+ "where contactId=:contactId";
		Map m = new HashMap();

		
		m.put("name", c.getName());
		m.put("email", c.getEmail());
		m.put("phone", c.getPhone());
		m.put("remarks", c.getRemarks());
		m.put("contactId", c.getContactId());
		
		getJdbcTemplate().update(sql, m);

		
	}

	@Override
	public void delete(Contact c) {
		// TODO Auto-generated method stub
		this.delete(c.getContactId());
	}

	@Override
	public void delete(int contactId) {
		// TODO Auto-generated method stub
		String sql="delete from contact where contactId=?";		
		getJdbcTemplate().update(sql, contactId);
	}

	@Override
	public Contact findById(int contactId) {
		// TODO Auto-generated method stub
		String sql = "select userId, name, email, phone, remarks from contact where contactId=?";
		
		Contact c=getJdbcTemplate().queryForObject(sql, new ContactRowMapper(),contactId);
		
		return c;
	}

	@Override
	public List<Contact> findByProperty(String propertyName, Object objectValue) {
		// TODO Auto-generated method stub
		String sql="select contactId, userId, name, email, phone, remarks from contact where "+propertyName+"=?";
		
		return getJdbcTemplate().query(sql, new ContactRowMapper(), objectValue);
	}

	@Override
	public List<Contact> findAll() {
		// TODO Auto-generated method stub
		String sql="select userId, name, email, phone, remarks from contact";
		
		List<Contact> cList=getJdbcTemplate().query(sql, new ContactRowMapper());
		
		
		return cList;
	}

}
