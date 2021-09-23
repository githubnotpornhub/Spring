package com.my.test;

import com.my.bean.ScoreDao;
import com.my.bean.StudentDao;
import com.my.bean.UserDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AopTest {
    public static void main(String[] args) {
        String xmlPath = "spring.xml";
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);

        //��Spring�����л�ô������
        UserDao userDao = (UserDao) applicationContext.getBean("userDaoProxy");
        StudentDao studentDao = (StudentDao) applicationContext.getBean("studentDaoProxy");
        ScoreDao scoreDao = (ScoreDao) applicationContext.getBean("scoreDaoProxy");

        //ִ�з���������ҵ����
        userDao.deleteUser();
        studentDao.deleteStudent();
        scoreDao.deleteScore();
    }
}
