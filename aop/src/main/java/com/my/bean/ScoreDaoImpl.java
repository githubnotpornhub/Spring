package com.my.bean;

import org.springframework.stereotype.Repository;

/*Ŀ����󣺳ɼ�����ģ��*/
@Repository("scoreDao")
public class ScoreDaoImpl implements ScoreDao {
    @Override
    public void addScore() {
        //int i=10/0;
        System.out.println("��ӳɼ�");

    }

    @Override
    public void deleteScore() {
        System.out.println("=====�ɼ�����ģ�飺ɾ���ɼ�=====");
    }
}
