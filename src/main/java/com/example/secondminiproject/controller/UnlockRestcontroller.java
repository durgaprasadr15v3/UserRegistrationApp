package com.example.secondminiproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.secondminiproject.binding.Login;
import com.example.secondminiproject.binding.UnlockAccount;
import com.example.secondminiproject.service.UnlockService;

@RestController
public class UnlockRestcontroller {
	
	@Autowired
	private UnlockService unlockService;
	
	@PostMapping("/unlockaccount")
	public String unlock(@RequestParam String email,@RequestBody UnlockAccount account)
	{
		return unlockService.unlockpassword(email,account);
	}
	
	@PostMapping("/login")
	public String login(@RequestBody Login login)
	{
		return unlockService.userlogin(login);
	}
	
//	@PostMapping("/forgetpassword")
//	public String login(@RequestBody ForgetPassword email)
//	{
//		return unlockService.forgetpassword(email);
//	}
//

}
