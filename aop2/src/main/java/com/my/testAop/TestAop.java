package com.my.testAop;

import com.my.bean.UserDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAop {
    public static void main(String[] args) {
        String xmlPath="spring.xml";
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext(xmlPath);

        //从Spring容器中获得内容
        UserDao userDao= (UserDao) applicationContext.getBean("userDao");
        //执行方法，进行业务处理
        userDao.deleteUser();
    }
}
