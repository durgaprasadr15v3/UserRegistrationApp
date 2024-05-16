package com.example.secondminiproject.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class CIty_master {
	@Id
	private int cityid;
	private String cityName;
	private String stateName;
	public String getStateName() {
		return stateName;
	}
	public void setStateName(String stateName) {
		this.stateName = stateName;
	}
	public int getCityid() {
		return cityid;
	}
	public void setCityid(int cityid) {
		this.cityid = cityid;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	
	

}
