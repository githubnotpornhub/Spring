package com.my.test;

import com.my.entity.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.Reader;

public class MybatisTest {

    private static SqlSessionFactory sqlSessionFactory = null;

    //初始化SqlSessionFactory对象  静态代码块在这里的作用是什么
    static {
        try {
            //使用Mybatis提供的Resources类加载Mybatis的XML配置文件
            Reader reader = Resources.getResourceAsReader("mybatis.xml");
            //构建SqlSessionFactory对象
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //获取SqlSession对象的静态方法
    public static SqlSession getSession() {
        return sqlSessionFactory.openSession();
    }

    //根据ID查询用户信息
    public void findUserByIdTest() {
        //获取SqlSession
        SqlSession sqlSession = getSession();
        //SqlSession执行映射文件中定义的SQL语句，并返回映射结果
        User user=sqlSession.selectOne("com.my.mapper."+"UserMapper.findUserById",3);

        //输出结果
        System.out.println(user.toString());
        //关闭SqlSession
        sqlSession.close();
    }

    public static void main(String[] args) {
        MybatisTest test=new MybatisTest();
        test.findUserByIdTest();
    }
}
