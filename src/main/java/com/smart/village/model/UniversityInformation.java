package com.smart.village.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
public class UniversityInformation {
	
	@Id
	//@GeneratedValue(strategy = GenerationType.AUTO)
	private int uId;
	private String name;
	private String imageUrl;
	private String description;
	private String contactInfo;
	private String noOfFaculty;
	private String noOfDepartment;
	private String websiteLink;
	
	@ManyToOne	
	@JsonIgnore
	private User user;

	public UniversityInformation(int uId, String name, String imageUrl, String description, String contactInfo,
			String noOfFaculty, String noOfDepartment, String websiteLink, User user) {
		super();
		this.uId = uId;
		this.name = name;
		this.imageUrl = imageUrl;
		this.description = description;
		this.contactInfo = contactInfo;
		this.noOfFaculty = noOfFaculty;
		this.noOfDepartment = noOfDepartment;
		this.websiteLink = websiteLink;
		this.user = user;
	}
	

	public UniversityInformation() {
		super();
		// TODO Auto-generated constructor stub
	}


	public int getuId() {
		return uId;
	}

	public void setuId(int uId) {
		this.uId = uId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getContactInfo() {
		return contactInfo;
	}

	public void setContactInfo(String contactInfo) {
		this.contactInfo = contactInfo;
	}

	public String getNoOfFaculty() {
		return noOfFaculty;
	}

	public void setNoOfFaculty(String noOfFaculty) {
		this.noOfFaculty = noOfFaculty;
	}

	public String getNoOfDepartment() {
		return noOfDepartment;
	}

	public void setNoOfDepartment(String noOfDepartment) {
		this.noOfDepartment = noOfDepartment;
	}

	public String getWebsiteLink() {
		return websiteLink;
	}

	public void setWebsiteLink(String websiteLink) {
		this.websiteLink = websiteLink;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "UniversityInformation [uId=" + uId + ", name=" + name + ", imageUrl=" + imageUrl + ", description="
				+ description + ", contactInfo=" + contactInfo + ", noOfFaculty=" + noOfFaculty + ", noOfDepartment="
				+ noOfDepartment + ", websiteLink=" + websiteLink + ", user=" + user + "]";
	}
	
	

}
