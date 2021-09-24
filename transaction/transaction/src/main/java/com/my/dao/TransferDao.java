package com.my.dao;

import com.my.entity.Account;

import java.util.List;

public interface TransferDao {


     void updateA(Account account);

     void updateB(Account account);
    //查看所有账户信息
     List findAllAccount();
}
