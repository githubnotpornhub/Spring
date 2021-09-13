package com.my.test;

import com.my.entity.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.Reader;

public class MybatisTest {

    private static SqlSessionFactory sqlSessionFactory = null;

    //��ʼ��SqlSessionFactory����  ��̬������������������ʲô
    static {
        try {
            //ʹ��Mybatis�ṩ��Resources�����Mybatis��XML�����ļ�
            Reader reader = Resources.getResourceAsReader("mybatis.xml");
            //����SqlSessionFactory����
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //��ȡSqlSession����ľ�̬����
    public static SqlSession getSession() {
        return sqlSessionFactory.openSession();
    }

    //����ID��ѯ�û���Ϣ
    public void findUserByIdTest() {
        //��ȡSqlSession
        SqlSession sqlSession = getSession();
        //SqlSessionִ��ӳ���ļ��ж����SQL��䣬������ӳ����
        User user=sqlSession.selectOne("com.my.mapper."+"UserMapper.findUserById",3);

        //������
        System.out.println(user.toString());
        //�ر�SqlSession
        sqlSession.close();
    }

    public static void main(String[] args) {
        MybatisTest test=new MybatisTest();
        test.findUserByIdTest();
    }
}
