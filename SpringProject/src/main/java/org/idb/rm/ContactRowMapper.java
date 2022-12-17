package org.idb.rm;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.idb.entity.Contact;
import org.springframework.jdbc.core.RowMapper;

public class ContactRowMapper implements RowMapper<Contact>{

	@Override
	public Contact mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		
		Contact c=new Contact();
		
		c.setContactId(rs.getInt("contactId"));
		c.setUserId(rs.getInt("userId"));
		c.setName(rs.getString("name"));
		c.setEmail(rs.getString("email"));
		c.setPhone(rs.getString("phone"));
		c.setRemarks(rs.getString("remarks"));
		
		return c;
	}

	
	
}
