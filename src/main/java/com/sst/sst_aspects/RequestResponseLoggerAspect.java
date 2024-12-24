package com.sst.sst_aspects;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import jakarta.servlet.http.HttpServletRequest;

@Aspect
@Component
public class RequestResponseLoggerAspect {
	 private static final Logger logger = LoggerFactory.getLogger(RequestResponseLoggerAspect.class);

	    @Around("execution(* com.example.demo.controller..*(..))")
	    public Object logApiRequestsAndResponses(ProceedingJoinPoint joinPoint) throws Throwable {
	        // Log Request Details
	        HttpServletRequest request = 
	                ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();

	        logger.info("\n[REQUEST] \nMethod: {} \nURL: {} \nHeaders: {} \nParameters: {} \nBody: {}", 
	                request.getMethod(),
	                request.getRequestURL().toString(),
	                request.getParameterMap(),
	                Arrays.toString(joinPoint.getArgs()));

	        // Proceed with Method Execution
	        Object response;
	        try {
	            response = joinPoint.proceed();
	        } catch (Throwable ex) {
	            logger.error("[EXCEPTION] Message: {}", ex.getMessage());
	            throw ex;
	        }

	        // Log Response Details
	        logger.info("[RESPONSE] {}", response);

	        return response;
	    }
}
