package com.example.secondminiproject.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.secondminiproject.binding.UserBinding;
import com.example.secondminiproject.entity.User;
import com.example.secondminiproject.service.RegistrationService;

@RestController
public class UserRestController {
	
	@Autowired
	private RegistrationService registrationService;
	
	
	@PostMapping("/saveuserdetails")
	public String userform(@RequestBody UserBinding userBinding)
	{
		boolean result= registrationService.userformdata(userBinding);
		if(result)
		{
			return "user registation sucessful";
		}
		return "user registation not sucessful";
	}
	
	@GetMapping("/getcountrydetails")
	public Map<Integer,String> getcountry()
	{
		return registrationService.countrydata();
	}
	
	@GetMapping("/getstatedetails/{countryid}")
	public Map<Integer,String> getstate(@PathVariable int countryid)
	{
		return registrationService.statedata(countryid);
	}
	
	@GetMapping("/getcitydetails/{statename}")
	public List<String>getcitydetails(@PathVariable String statename)
	{
		return registrationService.citydata(statename);
	}
	
	
	@GetMapping("/getuser/{id}")
	public Optional<User> getdetailsbyid(@PathVariable int id)
	{
		return registrationService.getbyid(id);
	}
	
	@GetMapping("/getalluserdetails")
	public List<User> getalluserdetails()
	{
		return registrationService.getalluserdetails();
	}
	
	
	@GetMapping("/arthimatic")
	public String arthimatic()
	{
		return registrationService.geterror();
	}
	
}
