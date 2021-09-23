package com.my.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

/*SpringAOP整合了AspectJ，基于AspectJ实现AOP有两种方式
* 一种是基于XML文件的方式
* 另一种是基于注解的方式
* 此处为使用XML文件的方式*/
public class MyAspect {
    //前置通知
    public void before(JoinPoint joinPoint){
        System.out.println("AOP的目标对象是："+joinPoint.getTarget());
        System.out.println("前置通知：如执行权限检查。。。。");
        System.out.println("被织入增强处理的目标方法为："+joinPoint.getSignature().getName());
    }

    //后置通知
    public void afterReturning(JoinPoint joinPoint){
        System.out.println("后置通知：如进行日志记录。。。。");
        System.out.println("被织入增强处理的目标方法为："+joinPoint.getSignature().getName());
    }

    //环绕通知
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        //开始
        System.out.println("环绕开始：执行目标方法之前，如开启事务。。。。");
        //执行当前目标方法
        Object obj= proceedingJoinPoint.proceed();
        //结束
        System.out.println("环绕结束：执行目标方法之后，如关闭事务。。。。");
        return obj;
    }

    //异常通知
    public void afterThrowing(JoinPoint joinPoint,Throwable throwable){
        System.out.println("异常通知："+"出错了"+throwable.getMessage());
    }

    //最终通知
    public void after(){
        System.out.println("最终通知：如方法结束后的释放资源。。。。");
    }
}
