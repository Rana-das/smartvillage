package com.smart.village.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class UserSms extends Admin {
	
	private String name;
	@Id
	private String email;
	private String subject;
	private String comment;
	private String number;
	public UserSms() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserSms(String name, String email, String subject, String comment, String number) {
		super();
		this.name = name;
		this.email = email;
		this.subject = subject;
		this.comment = comment;
		this.number = number;
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
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	@Override
	public String toString() {
		return "UserSms [name=" + name + ", email=" + email + ", subject=" + subject + ", comment=" + comment
				+ ", number=" + number + "]";
	}
	
	
	
	
}
