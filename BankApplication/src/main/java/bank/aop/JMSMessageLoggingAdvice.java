package bank.aop;

import bank.logging.ILogger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;

@Aspect
@Configuration
public class JMSMessageLoggingAdvice {
    private ILogger logger;

    @Autowired
    public JMSMessageLoggingAdvice(ILogger logger){
        this.logger = logger;
    }

    @After("execution(* bank.jms.JMSSender.sendJMSMessage(..)) && args(text)")
    public void logJMSMessages(JoinPoint joinPoint, String text){
        logger.log( LocalDateTime.now() + " | JMSMessage = " + text);
        System.out.println( LocalDateTime.now() + " | JMSMessage = " + text);
    }
}
