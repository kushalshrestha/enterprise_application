package customers.aop;

import customers.EmailSender;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;

@Aspect
@Configuration
public class EmailLoggingAdvice {
    @After("execution(* customers.EmailSender.sendEmail(..)) && args(email, message)")
    public void logMessage(JoinPoint joinPoint, String email, String message){
        EmailSender es = (EmailSender) joinPoint.getTarget();
        System.out.println(LocalDateTime.now() + " method=" + joinPoint.getSignature().getName() + " address= " + email
                + " message= " + message + " outgoing mail server = " + es.getOutgoingMailServer());
    }
}
