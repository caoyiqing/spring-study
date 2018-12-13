package com.cyq.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * AOP切面
 * @author admin
 *
 */
//@Configuration
//@Aspect
//@EnableAspectJAutoProxy
public class MyAspect {
	
	// 例如定义切入点表达式 execution (* com.sample.service.impl..*.*(..))
	// execution()是最常用的切点函数，其语法如下所示：
	// 整个表达式可以分为五个部分：
	// 1、execution(): 表达式主体。
	// 2、第一个*号：表示返回类型，*号表示所有的类型。
	// 3、包名：表示需要拦截的包名，后面的两个句点表示当前包和当前包的所有子包，com.sample.service.impl包、子孙包下所有类的方法。
	// 4、第二个*号：表示类名，*号表示所有的类。
	// 5、*(..):最后这个星号表示方法名，*号表示所有的方法，后面括弧里面表示方法的参数，两个句点表示任何参数。
	@Pointcut("execution(* com.cyq.service..*.*(..))")
	public void pointcut() {

	}
	
	@Before("pointcut()")
	public void doBefore(JoinPoint joinPoint) {
		System.out.println(joinPoint.getTarget().getClass() + " AOP 前置增强... " + joinPoint.getSignature().toString());
	}
	
	@After("pointcut()")
	public void doAfter(JoinPoint joinPoint) {
		System.out.println(joinPoint.getTarget().getClass() + " AOP 后置增强... " + joinPoint.getSignature().toString());
	}
	
//	@After("execution(* com.cyq.service..*.addOrder(..))")
//    public void doReleaseLock() {
//		System.out.println("AfterReturning doReleaseLock");
//    }
	
	@AfterReturning(pointcut = "execution(* com.cyq.service..*.addOrder(..))", returning = "object")
	public void doAfterReturning(JoinPoint joinPoint, Object object) {
		System.out.println(joinPoint.getTarget().getClass() + " AfterReturning... "
				+ joinPoint.getSignature().toString() + " 返回值 " + object.toString());
	}
	
	@AfterThrowing(pointcut = "execution(* com.cyq.service..*.addOrder(..))", throwing = "ex")
	public void doAfterThrowing(JoinPoint joinPoint, Exception ex) {
		System.out.println(joinPoint.getTarget().getClass() + " AfterThrowing... "
				+ joinPoint.getSignature().toString() + " 返回值 " + ex.getMessage());
	}
	
//	@Around("execution(* com.cyq.service..*.addOrder(..))")
//    public Object doAround(ProceedingJoinPoint pjp) throws Throwable {
//		System.out.println(pjp.getTarget().getClass() + " Around... "
//				+ pjp.getSignature().toString() + " start");
//        Object object = pjp.proceed();
//        
//        System.out.println(pjp.getTarget().getClass() + " Around... "
//				+ pjp.getSignature().toString() + " end 返回值 " + object.toString());
//        return object;
//    }
	
	
}
