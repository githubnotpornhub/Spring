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

    /*使用AOP和事务管理测试*/
    public void updateAOP() {
        /*操作第一步*/
        Account account1=new Account();
        account1.setAccount("A");
        account1.setBalance(1000);
        transferDao.updateA(account1);
        //模拟运行时出现突发异常导致操作失败
        //int i=1/0;
        /*操作第二步*/
        Account account2=new Account();
        account2.setAccount("B");
        account2.setBalance(1000);
        transferDao.updateB(account2);
    }

    /*使用AOP和事务管理测试*/
    public void noAOP() {
        /*操作第一步*/
        Account account1=new Account();
        account1.setAccount("A");
        account1.setBalance(1000);
        transferDao.updateA(account1);
        //模拟运行时出现突发异常导致操作失败
       // int i=1/0;
        /*操作第二步*/
        Account account2=new Account();
        account2.setAccount("B");
        account2.setBalance(1000);
        transferDao.updateB(account2);
    }

    /*查看所有账户信息*/
    public List<Map<String,Object>> findAllAccount() {
        return transferDao.findAllAccount();
    }
}
