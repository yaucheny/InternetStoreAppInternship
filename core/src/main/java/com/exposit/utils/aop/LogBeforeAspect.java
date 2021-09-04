package com.exposit.utils.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LogBeforeAspect {

    private static final Logger LOG = LoggerFactory.getLogger(LogBeforeAspect.class);

    @Before("execution(public * com.exposit.service.*.*(..))")
    public void logBeforeServiceMethod(JoinPoint joinPoint) {
        LOG.debug("execution of service method {}", joinPoint.getSignature().getName());
    }

    @Before("execution(public * com.exposit.controller.*.*(..))")
    public void logBeforeControllerMethod(JoinPoint joinPoint) {
        LOG.debug("execution of controller method {}", joinPoint.getSignature().getName());
    }

    @Before("execution(public * com.exposit.actions.*.*(..))")
    public void logBeforeFacadeMethod(JoinPoint joinPoint) {
        LOG.debug("execution of facade method {}", joinPoint.getSignature().getName());
    }
}
