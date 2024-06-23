package com.Bus;

public class User {
	private int cusid;
	private String fname;
	private String lname;
	private String email;
	private String address;
	private String phone;
	private String username;
	private String password;
	


	public User(int cusid, String fname, String lname, String email, String address, String phone, String username,
			String password) {
		
		this.cusid = cusid;
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.address = address;
		this.phone = phone;
		this.username = username;
		this.password = password;
	}

	public int getCusid() {
		return cusid;
	}

	public String getFname() {
		return fname;
	}
	public String getLname() {
		return lname;
	}

	public String getEmail() {
		return email;
	}

	public String getAddress() {
		return address;
	}

	public String getPhone() {
		return phone;
	}


	public String getUsername() {
		return username;
	}






	public String getPassword() {
		return password;
	}



	


	
	
}
