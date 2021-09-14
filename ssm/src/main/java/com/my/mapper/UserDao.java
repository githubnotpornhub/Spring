package com.my.mapper;

import com.my.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface UserDao {
    /*查询所有用户的信息*/
    public List<Map<String ,Object>> selectAllUsers();
    public List<User> selectUserListPage();
}
