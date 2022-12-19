package org.idb.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.idb.dao.BaseDao;
import org.idb.dao.IUserDao;
import org.idb.entity.User;
import org.idb.exception.UserBlockException;
import org.idb.rm.UserRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends BaseDao implements IUserService {

	@Autowired
	private IUserDao dao;

	@Override
	public void userRegiter(User u) {
		// TODO Auto-generated method stub
		this.dao.save(u);

	}

	@Override
	public User login(String loginName, String password) throws UserBlockException {
		// TODO Auto-generated method stub
		String sql = "select userId, name, phone, email, role, address, loginName, loginStatus from user where loginName=:ln and password=:pw";
		Map m = new HashMap();

		m.put("ln", loginName);
		m.put("pw", password);

		try {
			User u = getNamedParameterJdbcTemplate().queryForObject(sql, m, new UserRowMapper());
			if(u.getLoginStatus()==IUserService.LOGIN_STATUS_BLOCK) {
				throw new UserBlockException("Ur acc is blocked");
			}
			return u;
		} catch (EmptyResultDataAccessException ex) {
			return null;
		}

	}

	@Override
	public List<User> getUserList() {
		// TODO Auto-generated method stub
		
		return dao.findByProperty("role", IUserService.ROLE_USER); 
		
	}

	@Override
	public void chageLoginStatus(int userId, int loginStatus) {
		// TODO Auto-generated method stub

	}

}
