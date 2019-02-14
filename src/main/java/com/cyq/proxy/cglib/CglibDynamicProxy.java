package com.cyq.proxy.cglib;

import java.lang.reflect.Method;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

public class CglibDynamicProxy implements MethodInterceptor {

	// 被代理对象
	Object targetObject;

	// Generate a new class if necessary and uses the specified callbacks (if any)
	// to create a new object instance.
	// Uses the no-arg constructor of the superclass.
	// 动态生成一个新的类，使用父类的无参构造方法创建一个指定了特定回调的代理实例
	public Object getProxyObject(Object object) {
		this.targetObject = object;
		// 增强器，动态代码生成器
		Enhancer enhancer = new Enhancer();
		// 回调方法
		enhancer.setCallback(this);
		// 设置生成类的父类类型
		enhancer.setSuperclass(targetObject.getClass());
		// 动态生成字节码并返回代理对象
		return enhancer.create();
	}

	@Override
	public Object intercept(Object object, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
		System.out.println(this + "cglib proxy");
		Object result = methodProxy.invoke(targetObject, args);
		return result;
	}

}
