package com.example.prisesrdv.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@org.aspectj.lang.annotation.Aspect
public class Aspect {

    @After("execution(* com.example.prisesrdv.service.*.get*(..))")
    public void apres(JoinPoint thisJoinPoint) {
        log.info("Out of the method " + thisJoinPoint.getSignature().getName());
    }
}
