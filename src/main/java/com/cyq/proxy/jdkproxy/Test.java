package com.cyq.proxy.jdkproxy;

import com.cyq.proxy.staticproxy.JavaStudy;
import com.cyq.proxy.staticproxy.Study;

public class Test {
	
	public static void main(String[] args) {
		
		Study study = (Study)new JdkDynamicProxy().getProxyObject(new JavaStudy());
		
		study.study();
	}

}
