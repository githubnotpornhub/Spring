package com.my.bean;

import org.springframework.stereotype.Repository;

/*目标对象：成绩管理模块*/
@Repository("scoreDao")
public class ScoreDaoImpl implements ScoreDao {
    @Override
    public void addScore() {
        //int i=10/0;
        System.out.println("添加成绩");

    }

    @Override
    public void deleteScore() {
        System.out.println("=====成绩管理模块：删除成绩=====");
    }
}
