package com.cyq.service;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import com.cyq.aop.IdempotentRetry;

@Component
public class UserService {
	
	public UserService() {
		System.out.println(this + " 构造函数");
	}

	@Autowired
	private ApplicationContext applicationContext;
	
	private ThreadLocal<Integer> num = new ThreadLocal<>();
	
	public void setNum() {
		num.set(0);
	}
	
	@IdempotentRetry(maxRetries = 3)
	public String login() {
		System.out.println(this + "  login....");
		int z = 0;
		if (null != num.get()) {
			z = num.get().intValue();
		}
		num.set(1);
		int i = 1 / z;
		System.out.println(this + "  login success....");
		
		// 
		System.out.println(this + " 欢迎您 " + this.applicationContext.getMessage("cyq.name", null, Locale.CHINA));
		System.out.println(this + " 您爱" + this.applicationContext.getEnvironment().getProperty("cyq.love"));
		
		return "success";
	}

}
