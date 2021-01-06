package com.domains;


public class Basic_Info {

	private String name, dob, address, email, username, password, acc_type;
	 
	public Basic_Info() {
		super();
	}
	
	public Basic_Info(String name, String dob, String address, String email, String username, String password, String acc_type) {
		super();
		this.name = name;
		this.dob = dob;
		this.address = address;
		this.email = email;
		this.username = username;
		this.password = password;
		this.acc_type = acc_type;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}
	
	
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getAcc_type() {
		return acc_type;
	}

	public void setAcc_type(String acc_type) {
		this.acc_type = acc_type;
	}
	@Override
	public String toString() {
		return "Basic_Info [name=" + name + ", dob=" + dob + ", address=" + address + ", email=" + email + ", username="
				+ username + ", password=" + password + ", acc_type=" + acc_type + "]";
	}
}
