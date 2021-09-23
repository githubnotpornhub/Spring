package com.my.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAspect {

    /*定义切入点表达式*/
    @Pointcut("execution(* com.my.bean.*.*(..))")
    //使用一个返回值为void、方法体为空的方法来命名切入点
    private void myPointCut() {
    }

    //前置通知
    @Before("myPointCut()")
    public void before(JoinPoint joinPoint) {
        System.out.println("前置通知:模拟执行权限检查");
        System.out.println("目标对象是:" + joinPoint.getTarget());
        System.out.println("被织入增强处理的目标方法为:" + joinPoint.getSignature().getName());
    }

    //后置通知
    @AfterReturning(value = "myPointCut()")
    public void AfterReturning(JoinPoint joinPoint) {
        System.out.println("后置通知:模拟记录日志");
        System.out.println("被织入增强处理的目标方法为:" + joinPoint.getSignature().getName());
    }

    //环绕通知
    @Around("myPointCut()")
    public Object Around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        //开始
        System.out.println("环绕开始:执行目标方法之前，模拟开启事务。。。");
        //执行当前目标方法
        Object object = proceedingJoinPoint.proceed();
        //结束
        System.out.println("环绕结束:执行目标方法之后，模拟关闭事务。。。");
        return object;
    }

    //异常通知
    @AfterThrowing(value = "myPointCut()",throwing = "throwable")
    public void AfterThrowing(JoinPoint joinPoint,Throwable throwable){
        System.out.println("异常通知:"+"出错了"+throwable.getMessage());
    }

    //最终通知
    @After("myPointCut()")
    public void After(){
        System.out.println("最终通知:模拟方法结束后的释放资源。。。");
    }
}
