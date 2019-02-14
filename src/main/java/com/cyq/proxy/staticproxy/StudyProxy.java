package com.cyq.proxy.staticproxy;

public class StudyProxy implements Study {
	
	/** 持有被代理的对象*/
	private final Study study;
	
	public StudyProxy(Study study) {
		this.study = study;
	}

	@Override
	public String study() {
		System.out.println(this + " proxy study");
		return study.study();
	}

}
