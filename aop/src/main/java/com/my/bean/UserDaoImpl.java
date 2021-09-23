package com.my.bean;

import org.springframework.stereotype.Repository;

/*目标对象：用户管理模块*/
@Repository("userDao")
public class UserDaoImpl implements UserDao {
    @Override
    public void addUser() {
        //int i=10/0;
        System.out.println("添加用户");
    }

    @Override
    public void deleteUser() {
        System.out.println("=====用户管理模块：删除用户=====");
    }
}
