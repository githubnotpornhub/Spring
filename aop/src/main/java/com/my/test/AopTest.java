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

        //从Spring容器中获得代理对象
        UserDao userDao = (UserDao) applicationContext.getBean("userDaoProxy");
        StudentDao studentDao = (StudentDao) applicationContext.getBean("studentDaoProxy");
        ScoreDao scoreDao = (ScoreDao) applicationContext.getBean("scoreDaoProxy");

        //执行方法，进行业务处理
        userDao.deleteUser();
        studentDao.deleteStudent();
        scoreDao.deleteScore();
    }
}
