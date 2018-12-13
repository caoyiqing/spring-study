package com.cyq.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.core.Ordered;

/**
 * 重试的AOP切面
 * @author admin
 *
 */
@Configuration
@Aspect
@EnableAspectJAutoProxy
public class RetryAspect implements Ordered {
	
	/**
	 * 最多再尝试多少次
	 */
	private static final int DEFAULT_MAX_RETRIES = 2;

    private int maxRetries = DEFAULT_MAX_RETRIES;
    private int order = 1;

	public void setMaxRetries(int maxRetries) {
		this.maxRetries = maxRetries;
	}

	public void setOrder(int order) {
		this.order = order;
	}
	
	@Around("execution(* com.cyq.service..*.*(..)) && @annotation(idempotentRetry)")
	public Object doConcurrentOperation(ProceedingJoinPoint pjp, IdempotentRetry idempotentRetry) throws Throwable {
		int numAttempts = 0;
		Exception exception;
		do {
			numAttempts++;
			System.out.println(pjp.toString() + " 尝试第" + numAttempts + "次");
			try {
				return pjp.proceed();
			} catch (Exception ex) {
				exception = ex;
			}
		} while (numAttempts <= this.maxRetries);
		System.out.println(pjp.toString() + " 尝试" + numAttempts + "次均失败, 抛出异常");
		throw exception;
	}

	@Override
	public int getOrder() {
		return this.order;
	}

}
