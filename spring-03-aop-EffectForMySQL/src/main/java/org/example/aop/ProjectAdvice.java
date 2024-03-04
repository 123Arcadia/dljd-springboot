package org.example.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ProjectAdvice {
    @Pointcut("execution(* org.example.Service.*Service.*(..))")
    public void servicePt() {
    }

    /**
     * 添加环绕
     * @param proceedingJoinPoint
     * @throws Throwable
     */
//    @Around("servicePt()")
//    public Object runSpeed(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
//
//        Object res = proceedingJoinPoint.proceed();
//        return res;
//    }

    /**
     * 完成核心业务，记录万次执行的时间
     * @param proceedingJoinPoint
     * @throws Throwable
     * 得到签名：
     *      Signature signature = proceedingJoinPoint.getSignature();
     *         ProceedingJoinPoint中有一个getSignature()方法来获取签名，
     *         然后调用getDeclaringTypeName可以获取类名，getName()可以获取方法名
     */
    @Around("servicePt()")
    public void runSpeed(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
//        long start = System.currentTimeMillis();
//        for (int i = 0; i < 1000; i++) {
//            proceedingJoinPoint.proceed();
//        }
//        long end = System.currentTimeMillis();
//        System.out.println("业务层接口万次执行时间: " + (end - start) + "ms");

        Signature signature = proceedingJoinPoint.getSignature();
        String typeName = signature.getDeclaringTypeName();
        String methodName = signature.getName();
        long start = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            proceedingJoinPoint.proceed();
        }
        long end = System.currentTimeMillis();
        System.out.println("万次执行 " + typeName + "." + methodName + " 耗时" + (end - start) + "ms");
        //万次执行 org.example.Service.AccountService.findAll 耗时2255ms
    }
}