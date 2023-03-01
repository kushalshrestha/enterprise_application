package bank.aop;

import bank.logging.ILogger;
import bank.logging.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;

@Aspect
@Configuration
public class DAOMethodCallLoggingAdvice {
    private ILogger logger;

    @Autowired
    public DAOMethodCallLoggingAdvice(ILogger logger){
        this.logger = logger;
    }

    @Before("execution(* bank.dao.*.*(..))")
    public void logMethod(JoinPoint joinPoint){
        logger.log( LocalDateTime.now() + "  method=" + joinPoint.getSignature().getName());
        System.out.println("=============>" + LocalDateTime.now() + "  method=" + joinPoint.getSignature().getName());
    }

}
