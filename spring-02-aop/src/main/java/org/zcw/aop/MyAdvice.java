package org.zcw.aop;


import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyAdvice {
    /**
     * 设置切入点方法
     *         因为返回无参，所以是void,也可以是*通配符
     */
    @Pointcut("execution(void org.zcw.dao.impl.BookDaoImpl.update())")
    public void pt() {
    }

    /**
     * 设置当前通知方法与切入点之间的绑定关系，当前通知方法在原始切入点方法前运行
     */
    @Before("pt3()")
    public void method(){
        System.out.println(System.currentTimeMillis());
    }

    /**
     *     设置通配符匹配返回值
     */
    @Pointcut("execution(* org.zcw.dao.impl.BookDaoImpl.update())")
    public void pt1() {
    }

    /**
     * 返回值任意，但是update方法必须要有一个参数，无法匹配，要想匹配需要在update接口和实现类添加参数
     */
    @Pointcut("execution(* org.zcw.dao.impl.BookDaoImpl.update(*))")
    public void pt2() {
    }

    /**
     * 返回值为void,com包下的任意包三层包下的任意类的update方法，匹配到的是 -实现类- ，能匹配
     */
    @Pointcut("execution(* org.*.*.*.*.update())")
    public void pt3() {
    }


    /**
     * 返回值为void,com包下的任意包三层包下的任意类的update方法，匹配到的是 -接口- ，能匹配
     */
    @Pointcut("execution(* org.*.*.*.update())")
    private void pt4() {
    }

    /**
     * 返回值为void，方法名是update的任意包下的任意类，能匹配
     */
    @Pointcut("execution(void *..update())")
    private void pt5() {
    }

    /**
     * 还有其他表达方式
     */
}
