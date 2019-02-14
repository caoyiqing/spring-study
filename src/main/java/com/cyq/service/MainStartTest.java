package com.cyq.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import com.cyq.service.UserService;

@Component
public class MainStartTest {
	
	private static UserService userService;
	
	@Autowired  
    public void setDatastore(UserService userService) {  
		MainStartTest.userService = userService;  
    }
	
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("com.cyq.service",
				"com.cyq.ext", "com.cyq.aop");
		
		userService.login();
		
	}

}
