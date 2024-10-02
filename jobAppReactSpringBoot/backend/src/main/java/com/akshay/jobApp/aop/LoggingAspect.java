package com.akshay.jobApp.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {
    private static final Logger LOGGER = LoggerFactory.getLogger(LoggingAspect.class);

    // return-type fully-classified-class-name.method-name(args)
    @Before("execution(* com.akshay.jobApp.service.JobService.getJob(..)) || execution(* com.akshay.jobApp.service.JobService.updateJob(..))")
    public void logMethodCall(JoinPoint jp) {
        LOGGER.info("Method called: " + jp.getSignature().getName());
    }

    @After("execution(* com.akshay.jobApp.service.JobService.getJob(..)) || execution(* com.akshay.jobApp.service.JobService.updateJob(..))")
    public void logMethodExecuted(JoinPoint jp) {
        LOGGER.info("Method executed: " + jp.getSignature().getName());
    }

    @AfterThrowing("execution(* com.akshay.jobApp.service.JobService.getJob(..)) || execution(* com.akshay.jobApp.service.JobService.updateJob(..))")
    public void logMethodOnException(JoinPoint jp) {
        LOGGER.info("Method has some error: " + jp.getSignature().getName());
    }

    @AfterReturning("execution(* com.akshay.jobApp.service.JobService.getJob(..)) || execution(* com.akshay.jobApp.service.JobService.updateJob(..))")
    public void logMethodSuccessfully(JoinPoint jp) {
        LOGGER.info("Method executed successfully: " + jp.getSignature().getName());
    }
}
