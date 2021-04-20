package com.example.crud.interceptor;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.MDC;
import org.springframework.context.annotation.Configuration;

import java.util.UUID;

@Aspect
@Configuration
public class TraceabilityAspect {

	private static final String RANDOM_UUID = "uuid";

	@Before(value = "execution(* com.example.crud.controller.CustomerController.*(..))")
	public void before(JoinPoint joinPoint) {
		MDC.put(RANDOM_UUID, UUID.randomUUID().toString());
	}

	@After(value = "execution(* com.example.crud.controller.CustomerController.*(..))")
	public void afterReturning(JoinPoint joinPoint) {
		MDC.remove(RANDOM_UUID);
	}

}