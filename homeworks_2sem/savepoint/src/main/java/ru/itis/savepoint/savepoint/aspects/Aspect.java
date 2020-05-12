package ru.itis.savepoint.savepoint.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@org.aspectj.lang.annotation.Aspect
@Component
public class Aspect {

    @Pointcut("execution(public * ru.itis.savepoint.savepoint.service.TransactionService*(..)) && args(Long, ..)")
    public void pointcut(){}

    @Around("@annotation(SavePointAnnotation)")
    public String aroundAnnotation(ProceedingJoinPoint pjp){
        return pjp + "hi";
    }
}
