package com.cyq.proxy.jdkproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JdkDynamicProxy implements InvocationHandler {

	// 被代理的对象
	Object targetObject;

	public Object getProxyObject(Object object) {
		this.targetObject = object;
		return Proxy.newProxyInstance(targetObject.getClass().getClassLoader(), // 类加载器
				targetObject.getClass().getInterfaces(), // 获得被代理对象的所有接口
				this); // InvocationHandler对象
		// loader:一个ClassLoader对象，定义了由哪个ClassLoader对象来生成代理对象进行加载
		// interfaces:一个Interface对象的数组，表示的是我将要给我需要代理的对象提供一组什么接口，如果我提供了一组接口给它，那么这个代理对象就宣称实现了该接口(多态)，这样我就能调用这组接口中的方法了
		// this:一个InvocationHandler对象，表示的是当我这个动态代理对象在调用方法的时候，会关联到哪一个InvocationHandler对象上，间接通过invoke来执行
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println(this + " jdk proxy");
		return method.invoke(targetObject, args);
	}

}
