package com.cyq.ext;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

/**
 * bean 定义注册的处理器
 * @author admin
 *
 */
@Component
public class MyBeanDefinitonRegistryPostProcessor2 implements BeanDefinitionRegistryPostProcessor, Ordered {

	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		// TODO Auto-generated method stub
		System.out.println("MyBeanDefinitonRegistryPostProcessor2 postProcessBeanFactory 执行...");
	}

	@Override
	public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
		// TODO Auto-generated method stub
		System.out.println("MyBeanDefinitonRegistryPostProcessor2 postProcessBeanDefinitionRegistry 执行...");
	}

	@Override
	public int getOrder() {
		return 0;
	}

}
