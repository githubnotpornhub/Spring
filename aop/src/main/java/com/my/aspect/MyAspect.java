package com.my.aspect;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/*使用SpringAop(动态代理实现)
*Spring框架中AOP的实现有两种方式，即动态代理的方式和使用AspectJ框架的方式
*Spring的AOP代理也包括两种方式:一种是JDK动态代理，另一种是CGLIB代理
* 建议使用AspectJ框架来实现AOP。
* 使用AspectJ实现AOP有两种方式:一种是基于XML文件的方式，另一种是基于注解的方式(更加简洁)*/
/*切面类*/
public class MyAspect implements MethodInterceptor {

    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        //执行目标方法
        Object obj=methodInvocation.proceed();
        log();
        return obj;
    }
    public void log(){
        System.out.println("记录日志......");
    }
}
