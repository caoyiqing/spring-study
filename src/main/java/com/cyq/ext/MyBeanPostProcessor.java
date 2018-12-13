package com.cyq.ext;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import com.cyq.service.UserService;

/**
 * bean 处理器
 * 每个bean实例化都会执行一次
 * @author admin
 *
 */
@Component
public class MyBeanPostProcessor implements BeanPostProcessor {

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		// TODO Auto-generated method stub
		if (bean.getClass().equals(UserService.class)) {
			System.out.println("UserService 特殊处理...");
		}
		System.out.println("MyBeanPostProcessor postProcessBeforeInitialization 执行..." + bean.getClass());
		return BeanPostProcessor.super.postProcessBeforeInitialization(bean, beanName);
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		// TODO Auto-generated method stub
		System.out.println("MyBeanPostProcessor postProcessAfterInitialization 执行..." + bean.getClass());
		return BeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
	}
	
}
