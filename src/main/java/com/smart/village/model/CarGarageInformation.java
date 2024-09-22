package com.smart.village.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class CarGarageInformation {

	@Id
	//@GeneratedValue(strategy = GenerationType.AUTO)
	private int gId;
	private String name;
	private String imageUrl;
	private String description;
	private String contactInfo;
	private String location;
	private String garageSize;
	private String websiteLink;
	
	@ManyToOne	
	@JsonIgnore
	private User user;
	//01721238090

	public CarGarageInformation() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CarGarageInformation(int gId, String name, String imageUrl, String description, String contactInfo,
			String location, String garageSize, String websiteLink, User user) {
		super();
		this.gId = gId;
		this.name = name;
		this.imageUrl = imageUrl;
		this.description = description;
		this.contactInfo = contactInfo;
		this.location = location;
		this.garageSize = garageSize;
		this.websiteLink = websiteLink;
		this.user = user;
	}

	public int getgId() {
		return gId;
	}

	public void setgId(int gId) {
		this.gId = gId;
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

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getGarageSize() {
		return garageSize;
	}

	public void setGarageSize(String garageSize) {
		this.garageSize = garageSize;
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
		return "CarGarageInformation [gId=" + gId + ", name=" + name + ", imageUrl=" + imageUrl + ", description="
				+ description + ", contactInfo=" + contactInfo + ", location=" + location + ", garageSize=" + garageSize
				+ ", websiteLink=" + websiteLink + ", user=" + user + "]";
	}
	
	
}
