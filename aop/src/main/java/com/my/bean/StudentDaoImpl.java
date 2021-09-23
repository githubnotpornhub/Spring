package com.my.bean;

public class StudentDaoImpl implements StudentDao {
    @Override
    public void addStudent() {
        //int i=10/0;
        System.out.println("添加学生信息");
    }

    @Override
    public void deleteStudent() {
        System.out.println("=====学生管理模块：删除学生信息=====");
    }
}
