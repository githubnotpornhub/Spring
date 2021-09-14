package com.my.service;

import com.my.entity.User;

import java.util.List;
import java.util.Map;


public interface UserService {
    public List<Map<String ,Object>> selectAllUsers();
    public List<User> selectUserListPage();
}
