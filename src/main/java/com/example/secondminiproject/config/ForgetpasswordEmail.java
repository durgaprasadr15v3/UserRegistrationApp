//package com.example.secondminiproject.config;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.mail.SimpleMailMessage;
//import org.springframework.mail.javamail.JavaMailSender;
//import org.springframework.stereotype.Component;
//
//@Component
//public class ForgetpasswordEmail {
//
//	@Autowired 
//	public JavaMailSender javaMailSender;
//	@Value("${spring.mail.username}")
//	private String sender;
//	
//	public boolean emailsend(String subject,String email,String body) {
//		// TODO Auto-generated method stub
//		SimpleMailMessage mailMessage=new SimpleMailMessage();
//		//provide the 
//		
//		mailMessage.setFrom(sender);
//		
//		mailMessage.setSubject(subject);
//		mailMessage.setTo(email);
//		mailMessage.setText(body);
//		
//	    javaMailSender.send(mailMessage);
//		return true;
//	}
//
//	
//	
//}
