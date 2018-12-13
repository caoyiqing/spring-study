package com.cyq.ext;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.core.PriorityOrdered;
import org.springframework.stereotype.Component;

/**
 * bean 定义注册的处理器
 * 实现PriorityOrdered的优先级永远高于Ordered
 * @author admin
 *
 */
@Component
public class MyBeanDefinitonRegistryPostProcessor3 implements BeanDefinitionRegistryPostProcessor, PriorityOrdered {

	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		// TODO Auto-generated method stub
		System.out.println("MyBeanDefinitonRegistryPostProcessor3 postProcessBeanFactory 执行...");
	}

	@Override
	public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
		// TODO Auto-generated method stub
		System.out.println("MyBeanDefinitonRegistryPostProcessor3 postProcessBeanDefinitionRegistry 执行...");
	}

	@Override
	public int getOrder() {
		return 1;
	}

}
