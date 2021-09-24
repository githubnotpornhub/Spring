package com.my.service;

import com.my.dao.TransferDao;
import com.my.entity.Account;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class TransferService  {

    @Resource
    TransferDao transferDao;

    /*ʹ��AOP������������*/
    public void updateAOP() {
        /*������һ��*/
        Account account1=new Account();
        account1.setAccount("A");
        account1.setBalance(1000);
        transferDao.updateA(account1);
        //ģ������ʱ����ͻ���쳣���²���ʧ��
        //int i=1/0;
        /*�����ڶ���*/
        Account account2=new Account();
        account2.setAccount("B");
        account2.setBalance(1000);
        transferDao.updateB(account2);
    }

    /*ʹ��AOP������������*/
    public void noAOP() {
        /*������һ��*/
        Account account1=new Account();
        account1.setAccount("A");
        account1.setBalance(1000);
        transferDao.updateA(account1);
        //ģ������ʱ����ͻ���쳣���²���ʧ��
       // int i=1/0;
        /*�����ڶ���*/
        Account account2=new Account();
        account2.setAccount("B");
        account2.setBalance(1000);
        transferDao.updateB(account2);
    }

    /*�鿴�����˻���Ϣ*/
    public List<Map<String,Object>> findAllAccount() {
        return transferDao.findAllAccount();
    }
}
