package com.smart.village.model;

import org.springframework.context.annotation.Configuration;

@Configuration
public class LinkClick {
	private boolean active ;
	private DistrictInformation districtInformation;
	 
	public DistrictInformation getDistrictInformation() {
		return districtInformation;
	}

	public void setDistrictInformation(DistrictInformation districtInformation) {
		this.districtInformation = districtInformation;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
}
