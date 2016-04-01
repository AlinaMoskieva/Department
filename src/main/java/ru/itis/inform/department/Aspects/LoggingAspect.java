package ru.itis.inform.department.Aspects;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
    private static final Logger log = Logger.getLogger(LoggingAspect.class); //check

    @After("execution ( * ru.itis.inform.department.*(..))")
    public void logMethodExecution (JoinPoint jp){
        log.info(jp.toShortString());
    }
}
