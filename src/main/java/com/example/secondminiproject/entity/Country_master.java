package com.example.secondminiproject.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Country_master {
	
	@Id
	private int countryid;
	private String countryname;
	
	public int getCountryid() {
		return countryid;
	}

	public void setCountryid(int countryid) {
		this.countryid = countryid;
	}

	public String getCountryname() {
		return countryname;
	}

	public void setCountryname(String countryname) {
		this.countryname = countryname;
	}

	@Override
	public String toString() {
		return "Country_master [countryid=" + countryid + ", countryname=" + countryname + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	

}
