package org.baiDuWangPan.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyAdvice {
    @Pointcut("execution(* org.baiDuWangPan.Service.*Service.*(..))")
    public void pt(){}

    @Around("pt()")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        Object[] args = pjp.getArgs();
        for (int i = 0; i < args.length; i++) {
            if ((String.class).equals(args[i].getClass())){
                args[i] = args[i].toString().trim();
            }
        }
        Object res = pjp.proceed(args);
        return res;
    }
}