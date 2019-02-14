package com.cyq.proxy.staticproxy;

public class Test {
	
	public static void main(String[] args) {
		
		StudyProxy studyProxy = new StudyProxy(new JavaStudy());
		studyProxy.study();
		
		StudyProxy pythonStudy = new StudyProxy(new PythonStudy());
		pythonStudy.study();
		
	}

}
