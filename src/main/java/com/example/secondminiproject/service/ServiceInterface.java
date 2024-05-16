package com.example.secondminiproject.service;

import java.util.List;
import java.util.Map;

import com.example.secondminiproject.binding.UserBinding;

public interface ServiceInterface {
	
	//user registration binding class 
	public boolean userformdata(UserBinding userBinding); 
	
	
	public Map<Integer,String> countrydata();
	
	public Map<Integer,String> statedata(int countryid);
	
	public List<String> citydata(String statename);
	
	public boolean uniqueemail(String email);
	
	

}
