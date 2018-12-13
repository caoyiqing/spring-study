package com.cyq.ext;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

@Configuration
@PropertySource("classpath:/application.properties")
public class MyConfiguration {

	/**
	 * 
	* @Title: getReloadableResourceBundleMessageSource
	* @Description: 国际化标签
	* @param @return    设定文件
	* @return ReloadableResourceBundleMessageSource    返回类型
	* @throws
	 */
	@Bean("messageSource")
	public ReloadableResourceBundleMessageSource getReloadableResourceBundleMessageSource() {
		ReloadableResourceBundleMessageSource rms = new ReloadableResourceBundleMessageSource();
		rms.setBasename("message");
		return rms;
	}
}
