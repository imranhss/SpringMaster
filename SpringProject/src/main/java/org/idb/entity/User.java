package org.idb.entity;

public class User {

	private int userId;
	private String name;
	private String phone;
	private String email;
	private String address;
	private String loginName;
	private String password;
	private int role;
	private int loginStatus;

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(int userId, String name, String phone, String email, String address, String loginName,
			String password, int role, int loginStatus) {
		super();
		this.userId = userId;
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.address = address;
		this.loginName = loginName;
		this.password = password;
		this.role = role;
		this.loginStatus = loginStatus;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
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

	public int getRole() {
		return role;
	}

	public void setRole(int role) {
		this.role = role;
	}

	public int getLoginStatus() {
		return loginStatus;
	}

	public void setLoginStatus(int loginStatus) {
		this.loginStatus = loginStatus;
	}

}
