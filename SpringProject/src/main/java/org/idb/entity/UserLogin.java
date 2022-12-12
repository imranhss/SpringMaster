package org.idb.entity;

public class UserLogin {

	private String loginName;
	private String password;
	
	public UserLogin() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserLogin(String loginName, String password) {
		super();
		this.loginName = loginName;
		this.password = password;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
}
