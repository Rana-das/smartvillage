package com.smart.village.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name = "user")
public class User {
	@Id		
	private String issocode;
	private String username;
	private String password;
	private boolean enabled;
	private String nationality;
	private String address;
	private String website;
	private String twitter;
	private String instagram;
	private String facebook;
	private String city;
	@Column(unique = true)
	private String email;
	private String phone;
	private String imageUrl;
	private String role;
	
	@OneToMany(mappedBy = "user",cascade = CascadeType.ALL,orphanRemoval = true)
	private List<HospitlInformation> hospitlInformations=new ArrayList<>();
	
	

	public List<HospitlInformation> getHospitlInformations() {
		return hospitlInformations;
	}

	public void setHospitlInformations(List<HospitlInformation> hospitlInformations) {
		this.hospitlInformations = hospitlInformations;
	}
	
	@OneToMany(mappedBy = "user",cascade = CascadeType.ALL,orphanRemoval = true)
	private List<UniversityInformation> universityInformation=new ArrayList<>();
	
	
	
	public List<UniversityInformation> getUniversityInformation() {
		return universityInformation;
	}
	
	public void setUniversityInformation(List<UniversityInformation> universityInformation) {
		this.universityInformation = universityInformation;
	}
	
	@OneToMany(mappedBy = "user",cascade = CascadeType.ALL,orphanRemoval = true)
	private List<HistoricalPlaceInformation> historicalPlaceInformation=new ArrayList<>();
	
	

	public List<HistoricalPlaceInformation> getHistoricalPlaceInformation() {
		return historicalPlaceInformation;
	}

	public void setHistoricalPlaceInformation(List<HistoricalPlaceInformation> historicalPlaceInformation) {
		this.historicalPlaceInformation = historicalPlaceInformation;
	}
	
	@OneToMany(mappedBy = "user",cascade = CascadeType.ALL,orphanRemoval = true)
	private List<TraditionalFoodInformation> traditionalFoodInformation=new ArrayList<>();
	
	

	public List<TraditionalFoodInformation> getTraditionalFoodInformation() {
		return traditionalFoodInformation;
	}

	public void setTraditionalFoodInformation(List<TraditionalFoodInformation> traditionalFoodInformation) {
		this.traditionalFoodInformation = traditionalFoodInformation;
	}
	
	@OneToMany(mappedBy = "user",cascade = CascadeType.ALL,orphanRemoval = true)
	private List<CarGarageInformation> cargarageInformation=new ArrayList<>();
	
	

	public List<CarGarageInformation> getCarGarageInformation() {
		return cargarageInformation;
	}

	public void setCarGarageInformation(List<CarGarageInformation> cargarageInformation) {
		this.cargarageInformation = cargarageInformation;
	}
	
	

	public String getIssocode() {
		return issocode;
	}

	public void setIssocode(String issocode) {
		this.issocode = issocode;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}		
	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getNationality() {
		return nationality;
	}

	

	public String getAddress() {
		return address;
	}

	

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getTwitter() {
		return twitter;
	}

	public void setTwitter(String twitter) {
		this.twitter = twitter;
	}

	public String getInstagram() {
		return instagram;
	}

	public void setInstagram(String instagram) {
		this.instagram = instagram;
	}

	public String getFacebook() {
		return facebook;
	}

	public void setFacebook(String facebook) {
		this.facebook = facebook;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}





	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String toString() {
		return "User [issocode=" + issocode + ", username=" + username + ", password=" + password + ", enabled="
				+ enabled + ", nationality=" + nationality + ", address=" + address + ", website=" + website
				+ ", twitter=" + twitter + ", instagram=" + instagram + ", facebook=" + facebook + ", city=" + city
				+ ", email=" + email + ", phone=" + phone + ", imageUrl=" + imageUrl + ", role=" + role + "]";
	}

	
	
}
