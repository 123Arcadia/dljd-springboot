package org.zcw1.aop;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Aspect
public class MyAdvice {

    @Pointcut("execution(void org.zcw1.dao.BookDao.update())")
    public void pt() {
    }

    @Pointcut("execution(* org.zcw1.dao.BookDao.select())")
    public void pt_select() {
    }

    @Pointcut("execution(* org.zcw1.dao.BookDao.findName(..))")
    public void pt_findNameForReturn(){
    }

    @Pointcut("execution(* org.zcw1.dao.BookDao.findName(..))")
    public void pt_findNameForArgs(){
    }

    @Before("pt()")
    public void before() {
        System.out.println("before advice ...");
    }

    @After("pt()")
    public void after(){
        System.out.println("after advice ...");
    }

    /**
     * 运行结果中，通知的内容打印出来，但是原始方法的内容却没有被执行
     *
     * > 为什么返回的是Object而不是int的主要原因是Object类型更通用。
     * > 在环绕通知中是可以对原始方法返回值就行修改的。例如上面的例子，
     *      可以改为return res+666;，最终的输出结果也会变为766
     */
    @Around("pt_select()")
    public Object around(ProceedingJoinPoint pjp) throws Throwable{
        System.out.println("around before advice ...");
        // 不是对原始方法的调用
        Object res = pjp.proceed();
        System.out.println("around after advice ...");
        return res;
    }

    @AfterReturning("pt_select()")
    public void afterReturning(){
        System.out.println("afterReturning advice ...");
    }

    /**
     * 异常后通知
     */
    @AfterThrowing("pt_select()")
    public void afterThrowing(){
        System.out.println("afterThrowing advice ...");
    }


    @Around("pt_findNameForReturn()")
    public Object around_findNameForReturn(ProceedingJoinPoint pjp) throws Throwable {
        Object[] args = pjp.getArgs();
        System.out.println("args[] : " + Arrays.toString(args));
        args[0] = 1111;
        Object res = pjp.proceed(args);
        return res;
    }

//    @Around("pt_findNameForArgs()")
//    public void around_findNameForArgs(JoinPoint joinPoint) {
//        Object[] args = joinPoint.getArgs();
//        System.out.println("args[] : " + Arrays.toString(args));
//        System.out.println("[around_findNameForArgs] before advice ...");
//    }

    /**
     * pjp.proceed
             * 1.可以无参，
             * 2.可以有参（可以中途自己改变值）
     * @param pjp
     * @return
     * @throws Throwable
     */
    @Around("pt_findNameForArgs()")
    public Object around_findNameForArgs(ProceedingJoinPoint pjp) throws Throwable {
        Object[] args = pjp.getArgs();
        System.out.println("args[] : " + Arrays.toString(args));

        args[0] = 9999;
        Object res = pjp.proceed(args);
        return res;
    }
}
