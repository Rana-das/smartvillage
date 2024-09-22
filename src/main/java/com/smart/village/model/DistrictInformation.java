package com.smart.village.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity(name = "districtInformation")
@Table(name = "districtInformation")
public class DistrictInformation {
	
	private String name;
	@Id
	private String isoCode;
	private String division;
	@Column(unique = true)
	private String divisionIssoCode;
	
	
	public DistrictInformation() {
		super();
		// TODO Auto-generated constructor stub
	}


	
	public DistrictInformation(String name, String isoCode, String division, String divisionIssoCode,
			List<HospitlInformation> hospitlInformations) {
		super();
		this.name = name;
		this.isoCode = isoCode;
		this.division = division;
		this.divisionIssoCode = divisionIssoCode;
	
	}






	public String getDivisionIssoCode() {
		return divisionIssoCode;
	}
	public void setDivisionIssoCode(String divisionIssoCode) {
		this.divisionIssoCode = divisionIssoCode;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIsoCode() {
		return isoCode;
	}
	public void setIsoCode(String isoCode) {
		this.isoCode = isoCode;
	}
	public String getDivision() {
		return division;
	}
	public void setDivision(String division) {
		this.division = division;
	}
	@Override
	public String toString() {
		return "DistrictInformation [name=" + name + ", isoCode=" + isoCode + ", division=" + division
				+ ", divisionIssoCode=" + divisionIssoCode + ", getDivisionIssoCode()=" + getDivisionIssoCode()
				+ ", getName()=" + getName() + ", getIsoCode()=" + getIsoCode() + ", getDivision()=" + getDivision()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
	
	
	
	
	

}
