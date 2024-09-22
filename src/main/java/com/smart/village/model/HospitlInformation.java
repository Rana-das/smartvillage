package com.smart.village.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
public class HospitlInformation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int hId;
	private String name;
	private String imageUrl;
	private String description;
	private String contactInfo;
	private String noOfICU;
	private String websiteLink;
	
	@ManyToOne	
	@JsonIgnore
	private User user;
	

	public HospitlInformation(int hId, String name, String image, String description, String contactInfo,
			String noOfICU, String websiteLink, User user) {
		super();
		this.hId = hId;
		this.name = name;
		this.imageUrl = image;
		this.description = description;
		this.contactInfo = contactInfo;
		this.noOfICU = noOfICU;
		this.websiteLink = websiteLink;
		this.user = user;
	}

	public HospitlInformation() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int gethId() {
		return hId;
	}

	public void sethId(int hId) {
		this.hId = hId;
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

	public String getNoOfICU() {
		return noOfICU;
	}

	public void setNoOfICU(String noOfICU) {
		this.noOfICU = noOfICU;
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
		return "HospitlInformation [hId=" + hId + ", name=" + name + ", imageUrl=" + imageUrl + ", description="
				+ description + ", contactInfo=" + contactInfo + ", noOfICU=" + noOfICU + ", websiteLink=" + websiteLink
				+ ", user=" + user + "]";
	}

	
	
	
	
	

}
