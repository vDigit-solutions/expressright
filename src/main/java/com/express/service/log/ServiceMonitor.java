package com.express.service.log;

import java.util.Arrays;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ServiceMonitor {
	
	 Logger logger = LogManager.getLogger(ServiceMonitor.class);

	
	@AfterThrowing(pointcut="execution(* com.express.service..*(..))",throwing="excep")
	public void logerrordsServiceAccess(JoinPoint joinPoint , Throwable excep) {
		logger.info("Method Name :" + joinPoint.getSignature().toShortString() + "| Args => " + Arrays.asList(joinPoint.getArgs()));
		logger.error("error: line no" + joinPoint.getSourceLocation() +" "+joinPoint.getSignature(),excep);
	}
	
	
	

}