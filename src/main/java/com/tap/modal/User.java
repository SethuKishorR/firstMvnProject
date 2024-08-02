package com.tap.modal;

public class User {
	private int id;
	private String name;
	private String email;
	private String phonenumber;
	private String password;
	private String address;
	public User() {
		super();
	}
	public User(int id, String name, String email, String phonenumber, String password, String address) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.phonenumber = phonenumber;
		this.password = password;
		this.address = address;
	}
	public User(String name, String email, String phonenumber, String password, String address) {
		super();
		this.name = name;
		this.email = email;
		this.phonenumber = phonenumber;
		this.password = password;
		this.address = address;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + ", phonenumber=" + phonenumber + ", password="
				+ password + ", address=" + address + "]";
	}
	
}
