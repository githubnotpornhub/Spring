package com.my.service;

import com.my.entity.User;
import com.my.mapper.UserDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;

    @Override
    public List<Map<String, Object>> selectAllUsers() {
        List list=userDao.selectAllUsers();
        return list;
    }

    @Override
    public List<User> selectUserListPage() {

        return userDao.selectUserListPage();
    }
}
