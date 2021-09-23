package com.my.aspect;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/*ʹ��SpringAop(��̬����ʵ��)
*Spring�����AOP��ʵ�������ַ�ʽ������̬����ķ�ʽ��ʹ��AspectJ��ܵķ�ʽ
*Spring��AOP����Ҳ�������ַ�ʽ:һ����JDK��̬������һ����CGLIB����
* ����ʹ��AspectJ�����ʵ��AOP��
* ʹ��AspectJʵ��AOP�����ַ�ʽ:һ���ǻ���XML�ļ��ķ�ʽ����һ���ǻ���ע��ķ�ʽ(���Ӽ��)*/
/*������*/
public class MyAspect implements MethodInterceptor {

    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        //ִ��Ŀ�귽��
        Object obj=methodInvocation.proceed();
        log();
        return obj;
    }
    public void log(){
        System.out.println("��¼��־......");
    }
}
