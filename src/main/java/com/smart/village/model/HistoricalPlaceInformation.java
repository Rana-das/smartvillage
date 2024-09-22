package com.smart.village.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class HistoricalPlaceInformation {


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int hpId;
	private String name;
	private String imageUrl;
	private String description;
	private String contactInfo;
	private String location;
	private String ticketcost;
	private String websiteLink;
	
	@ManyToOne	
	@JsonIgnore
	private User user;

	public HistoricalPlaceInformation() {
		super();
		// TODO Auto-generated constructor stub
	}

	public HistoricalPlaceInformation(int hpId, String name, String imageUrl, String description, String contactInfo,
			String location, String ticketcost, String websiteLink, User user) {
		super();
		this.hpId = hpId;
		this.name = name;
		this.imageUrl = imageUrl;
		this.description = description;
		this.contactInfo = contactInfo;
		this.location = location;
		this.ticketcost = ticketcost;
		this.websiteLink = websiteLink;
		this.user = user;
	}

	public int getHpId() {
		return hpId;
	}

	public void setHpId(int hpId) {
		this.hpId = hpId;
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

	public String getTicketcost() {
		return ticketcost;
	}

	public void setTicketcost(String ticketcost) {
		this.ticketcost = ticketcost;
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
		return "HistoricalPlaceInformation [hpId=" + hpId + ", name=" + name + ", imageUrl=" + imageUrl
				+ ", description=" + description + ", contactInfo=" + contactInfo + ", location=" + location
				+ ", ticketcost=" + ticketcost + ", websiteLink=" + websiteLink + ", user=" + user + "]";
	}
	
	
}
