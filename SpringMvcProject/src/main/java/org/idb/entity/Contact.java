package org.idb.entity;

public class Contact {

	private int contactId; // pk
	private int userId; // fk
	private String name;
	private String phone;
	private String email;
	private String remarks;

	public Contact() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Contact(int contactId, int userId, String name, String phone, String email, String remarks) {
		super();
		this.contactId = contactId;
		this.userId = userId;
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.remarks = remarks;
	}

	public int getContactId() {
		return contactId;
	}

	public void setContactId(int contactId) {
		this.contactId = contactId;
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

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

}
