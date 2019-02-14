package com.cyq.proxy.cglib;

import com.cyq.proxy.staticproxy.JavaStudy;
import com.cyq.proxy.staticproxy.Study;

public class Test {
	
public static void main(String[] args) {
		
		Study study = (Study)new CglibDynamicProxy().getProxyObject(new JavaStudy());
		
		study.study();
	}

}
