package com.example.secondminiproject.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class State_master {
	
	@Id
	private int stateid;
	private String statename;
	private int countryId;
	public int getStateid() {
		return stateid;
	}
	public void setStateid(int stateid) {
		this.stateid = stateid;
	}
	public String getStatename() {
		return statename;
	}
	public void setStatename(String statename) {
		this.statename = statename;
	}
	public int getCountryid() {
		return countryId;
	}
	public void setCountryid(int countryid) {
		this.countryId = countryid;
	}
	

}
