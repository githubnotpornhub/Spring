package com.my.test;

import com.my.bean.UserDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/*SpringAOP整合了AspectJ，基于AspectJ实现AOP有两种方式
 * 一种是基于XML文件的方式
 * 另一种是基于注解的方式
 * 此处为使用注解的方式*/
public class TestAspectJ {
    public static void main(String[] args) {
        String xmlPath = "spring.xml";
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);
        //从Spring容器中获得内容
        UserDao userDao = (UserDao) applicationContext.getBean("userDao");
        //执行业务处理方法
        userDao.addUser();
    }
}
