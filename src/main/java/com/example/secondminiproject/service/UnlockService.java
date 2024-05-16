package com.example.secondminiproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.secondminiproject.binding.Login;
import com.example.secondminiproject.binding.UnlockAccount;
import com.example.secondminiproject.entity.User;
import com.example.secondminiproject.repo.UnlockRepositroy;

@Service
public class UnlockService {

	
	@Autowired
	private UnlockRepositroy UnlockRepositroy;
	
	
	
//	@Autowired
//	private Email emailsender;
//	
	
	
	public String unlockpassword(String email,UnlockAccount account) {

        User user=UnlockRepositroy.findByEmail(email);		
		
		if(user.getPassword().equals(account.getTemppassword()))
		{
			user.setAccountStatus("active");
			user.setPassword(account.getComformpassword());
			
			UnlockRepositroy.save(user);
			return "your account is active please login your account";

		}
		return "your account Unlocked"; 
	}

	public String userlogin(Login login) {
		// TODO Auto-generated method stub
		
		User user=UnlockRepositroy.findByEmail(login.getEmail());
		if(user.getPassword().equals(login.getPassword()))
		{
			return "welcome to home page";
		}
		
	return "your login credencital is incorrect";	
	}

//	public String forgetpassword(ForgetPassword email) {
//		// TODO Auto-generated method stub
//		User user=UnlockRepositroy.findByEmail(email.getEmail());
//
//		if(user.getEmail()!=null)
//		{
//			String subject="This your password";
//			String body="this is your password"+user.getPassword();
//			emailsender.emailsend(subject,body,user.getEmail());	
//		}
//		
//		return "temporarypassword send to your email";
//	}

	
}
