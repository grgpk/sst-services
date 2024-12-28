package com.sst.sst_aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.http.HttpServletRequest;

@Aspect
@Component
public class RequestAndResponseLoggerAspect {

	private static final Logger logger = LoggerFactory.getLogger(RequestAndResponseLoggerAspect.class);
	private final ObjectMapper objectMapper = new ObjectMapper();

	@Pointcut("within(com.sst.sst_controllers..*)")
	public void restController() {

	}

	@Around("restController()")
	public Object logRequestsAndResponses(ProceedingJoinPoint joinPoint) throws Throwable {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
				.getRequest();

		// Log the HTTP method and URL
		logger.info("HTTP Method: {}", request.getMethod());
		logger.info("Request URI: {}", request.getRequestURI());

		// Log the method name and arguments
		MethodSignature signature = (MethodSignature) joinPoint.getSignature();
		String methodName = signature.getMethod().getName();
		Object[] methodArgs = joinPoint.getArgs();
		logger.info("Controller Method: {}", methodName);
		logger.info("Method Arguments: {}", objectMapper.writeValueAsString(methodArgs));

		// Proceed with the actual method execution
		Object response;
		try {
			response = joinPoint.proceed();
		} catch (Exception e) {
			logger.error("Exception in method {}: {}", methodName, e.getMessage());
			throw e;
		}

		// Log the response
		logger.info("Response: {}", objectMapper.writeValueAsString(response));
		return response;
	}
}
