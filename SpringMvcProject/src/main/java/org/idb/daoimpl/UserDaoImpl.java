package org.idb.daoimpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.idb.dao.BaseDao;
import org.idb.dao.IUserDao;
import org.idb.entity.User;
import org.idb.rm.UserRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl extends BaseDao implements IUserDao{

	@Override
	public void save(User u) {
		// TODO Auto-generated method stub
		String sql="insert into user(name,email,address,phone,loginName,role,userStatus,password)"
				+ "values(:name,:email,:address,:phone,:loginName,:role,:userStatus,:password)";
		
		Map m=new HashMap();
		
		m.put("name", u.getName());
		m.put("email", u.getEmail());
		m.put("address", u.getAddress());
		m.put("phone", u.getPhone());
		m.put("loginName", u.getLoginName());
		m.put("role", u.getRole());
		m.put("userStatus", u.getUserStatus());
		m.put("password", u.getPassword());
		
		KeyHolder kh=new GeneratedKeyHolder();
		
		SqlParameterSource ps=new MapSqlParameterSource(m);
		
		getNamedParameterJdbcTemplate().update(sql, ps, kh);
		
		Integer userId=kh.getKey().intValue();
		
		u.setUserId(userId);
		

	}

	@Override
	public void update(User u) {
		// TODO Auto-generated method stub		
		String sql="update  user set "
				+ "name=:name,"
				+ "email=:email,"
				+ "address=:address,"
				+ "phone=:phone,"
				+ "password=:password "
				+ "where userId=:userId";
				
		Map m=new HashMap();
		
		m.put("name", u.getName());
		m.put("email", u.getEmail());
		m.put("address", u.getAddress());
		m.put("phone", u.getPhone());	
		m.put("password", u.getPassword()); 
		m.put("userId", u.getUserId());
		
		
		getNamedParameterJdbcTemplate().update(sql, m);
		
	}

	@Override
	public void delete(User u) {
		// TODO Auto-generated method stub		
		this.delete(u.getUserId());
		
	}

	@Override
	public void delete(int userId) {
		// TODO Auto-generated method stub
		String sql="delete from user where userId=?";
		getJdbcTemplate().update(sql, userId);		
		
	}

	@Override
	public User findById(int userId) {
		// TODO Auto-generated method stub
		String sql="select userId, name,email,address,phone,loginName,role,userStatus,password from user"
				+ " where userId=?";
		
		User u=getJdbcTemplate().queryForObject(sql, new UserRowMapper(), userId);
		
		return u;
		 
	}

	@Override
	public List<User> findByProperty(String propertyName, Object objectValue) {
		// TODO Auto-generated method stub
		// for find all types of user by name, email, address, remarks, phone
		
		String sql="select name,email,address,phone,loginName,role,userStatus,password from user"
				+ " where"+propertyName+"=?";

		return getJdbcTemplate().query(sql, new UserRowMapper(), objectValue);
	}

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		String sql="select userId,name,email,address,phone,loginName,role,userStatus,password from user";
		List<User> userList=getJdbcTemplate().query(sql, new UserRowMapper());
		
		return userList;
	}
	
	

}
