package com.cyq;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.cyq.service.AccountService;
import com.cyq.service.IOrderService;
import com.cyq.service.UserService;

public class Start {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("com.cyq.service",
				"com.cyq.ext", "com.cyq.aop");

		UserService userService = context.getBean(UserService.class);
		userService.setNum();
		userService.login();
		
		AccountService accountService = context.getBean(AccountService.class);
		accountService.pay();
		
		IOrderService orderService = context.getBean(IOrderService.class);
		orderService.addOrder();
		
		context.close();

	}

}
