package com.my.testAop;

import com.my.bean.UserDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAop {
    public static void main(String[] args) {
        String xmlPath="spring.xml";
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext(xmlPath);

        //��Spring�����л������
        UserDao userDao= (UserDao) applicationContext.getBean("userDao");
        //ִ�з���������ҵ����
        userDao.deleteUser();
    }
}
