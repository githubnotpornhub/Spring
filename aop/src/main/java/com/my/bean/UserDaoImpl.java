package com.my.bean;

import org.springframework.stereotype.Repository;

/*Ŀ������û�����ģ��*/
@Repository("userDao")
public class UserDaoImpl implements UserDao {
    @Override
    public void addUser() {
        //int i=10/0;
        System.out.println("����û�");
    }

    @Override
    public void deleteUser() {
        System.out.println("=====�û�����ģ�飺ɾ���û�=====");
    }
}
