package org.idb.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
<<<<<<< HEAD
import org.id.dao.BaseDao;
import org.id.dao.IUserDao;
=======
>>>>>>> 2bd2137568b7535a24463160f5e59cddfb6f5b39
import org.idb.entity.User;
import org.idb.rm.UserRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;


@Repository
public class UserDaoImpl extends BaseDao implements IUserDao {

	
	@Override
	public void save(User u) {
		// TODO Auto-generated method stub
		String sql = "insert into user(name, phone, email, address, loginName, password, role,loginStatus) "
				+ "values(:name, :phone, :email, :address, :loginName, :password, :role, :loginStatus)";

		Map m = new HashMap<>();

		m.put("name", u.getName());
		m.put("phone", u.getPhone());
		m.put("email", u.getEmail());
		m.put("address", u.getAddress());
		m.put("loginName", u.getLoginName());
		m.put("password", u.getPassword());
		m.put("role", u.getRole());
		m.put("loginStatus", u.getLoginStatus());

		KeyHolder kh = new GeneratedKeyHolder();

		SqlParameterSource ps = new MapSqlParameterSource(m);

		getNamedParameterJdbcTemplate().update(sql, ps, kh);
		Integer userId = kh.getKey().intValue();
		u.setUserId(userId);

	}

	@Override
	public void update(User u) {
		String sql = "update user  set name=:name," + "email=:email, " + "address=:address, " + "role=:role,"
				+ "loginStatus=:loginStatus" + "where userId=:userId";

		Map m = new HashMap<>();

		m.put("name", u.getName());
		m.put("phone", u.getPhone());
		m.put("emil", u.getEmail());
		m.put("address", u.getAddress());
		m.put("role", u.getRole());
		m.put("loginStatus", u.getLoginStatus());
		m.put("userId", u.getUserId());

		getNamedParameterJdbcTemplate().update(sql, m);
		

	}

	@Override
	public void delete(User u) {
		// TODO Auto-generated method stub
		this.delete(u.getUserId());
	}

	@Override
	public void delete(int userid) {
		// TODO Auto-generated method stub
		String sql="delete from user where userid=?";
		getJdbcTemplate().update(sql, userid);
				
	}

	@Override
	public User findById(int userId) {
		// TODO Auto-generated method stub
		String sql="select userId, nama, phone, email, address,loginName, role, loginStatus where userId=?";
		User u=getJdbcTemplate().queryForObject(sql,new UserRowMapper(), userId);
		
		return u;
	}

	@Override
	public List<User> findByProperty(String propertyName, Object objectValue) {
		// TODO Auto-generated method stub
		String sql="select userId, nama, phone, email, address,loginName, role, loginStatus from user"
				+ " where"+propertyName+"=?";
		
		
		return getJdbcTemplate().query(sql,new UserRowMapper(), objectValue);
		
	}

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		String sql="select userId, name, phone, email, address, loginName, role, loginStatus from user";
		
		List<User> list= getJdbcTemplate().query(sql, new UserRowMapper());
		return list;
	}

}
