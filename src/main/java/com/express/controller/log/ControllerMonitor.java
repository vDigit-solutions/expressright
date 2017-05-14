package com.express.controller.log;

import java.util.Arrays;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ControllerMonitor {
	
	 Logger logger = LogManager.getLogger(ControllerMonitor.class);

	@AfterReturning("execution(* com.express.controller..*(..))")
	public void logServiceAccess(JoinPoint joinPoint) {
		logger.info("Method Name :" + joinPoint.getSignature().toShortString() + "| Args => " + Arrays.asList(joinPoint.getArgs()));
    }
	
	
	

}