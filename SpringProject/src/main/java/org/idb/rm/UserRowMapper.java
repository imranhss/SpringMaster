package org.idb.rm;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.idb.entity.User;
import org.springframework.jdbc.core.RowMapper;

public class UserRowMapper implements RowMapper<User>{

	@Override
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		User u=new User();
		u.setUserId(rs.getInt("userId"));
		u.setName(rs.getString("name"));
		u.setEmail(rs.getString("email"));
		u.setPhone(rs.getString("phone"));
		u.setAddress(rs.getString("address"));
		u.setLoginName(rs.getString("loginName"));
		u.setRole(rs.getInt("role"));
		u.setLoginStatus(rs.getInt("loginStatus"));
		
		return u;
	}
	
	

}
