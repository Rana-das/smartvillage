package com.smart.village.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class TraditionalFoodInformation {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int tfId;
	private String name;
	private String imageUrl;
	private String description;
	private String contactInfo;
	private String location;
	private String cost;
	private String websiteLink;
	
	@ManyToOne	
	@JsonIgnore
	private User user;

	public TraditionalFoodInformation() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TraditionalFoodInformation(int tfId, String name, String imageUrl, String description, String contactInfo,
			String location, String cost, String websiteLink, User user) {
		super();
		this.tfId = tfId;
		this.name = name;
		this.imageUrl = imageUrl;
		this.description = description;
		this.contactInfo = contactInfo;
		this.location = location;
		this.cost = cost;
		this.websiteLink = websiteLink;
		this.user = user;
	}

	public int getTfId() {
		return tfId;
	}

	public void setTfId(int tfId) {
		this.tfId = tfId;
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

	public String getCost() {
		return cost;
	}

	public void setCost(String cost) {
		this.cost = cost;
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
		return "TraditionalFoodInformation [tfId=" + tfId + ", name=" + name + ", imageUrl=" + imageUrl
				+ ", description=" + description + ", contactInfo=" + contactInfo + ", location=" + location + ", cost="
				+ cost + ", websiteLink=" + websiteLink + ", user=" + user + "]";
	}
	
	
}
