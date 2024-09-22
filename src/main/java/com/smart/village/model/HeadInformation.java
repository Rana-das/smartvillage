package com.smart.village.model;

public class HeadInformation {
	private String email;
	private String password;
	public HeadInformation(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}
	public HeadInformation() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getEmail() {
		return "sojib.19991018@gmail.com";
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return "1234";
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	

}
