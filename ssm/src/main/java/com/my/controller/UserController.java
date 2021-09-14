package com.my.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.my.entity.User;
import com.my.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Controller
public class UserController {

    @Resource
    private UserService userService;

    @RequestMapping("getAll")
    public String getAllUsers (Model model){
        List<Map<String,Object>> list=userService.selectAllUsers();
        model.addAttribute("list",list);
        return "userList";
    }

    @RequestMapping("pageSearch")
    public String getByPages(@RequestParam(name="page",defaultValue="1") Integer page,
                                     Model model){
        PageHelper.startPage(page, 5);//每页条数=3
        //查询数据
        List<User> list = userService.selectUserListPage();
        //查看一下是否查到了数据
        for (User user : list) {
            System.out.println("========="+user);
        }
        /**
         * pageNum:当前页
         * pageSize:每页的数量
         * size:当前页的数量
         * pages:总页数
         * total:总记录数
         */

        /**
         *  PageInfo就是当初那个分页工具类(分页bean)
         */
        PageInfo<User> pageInfo = new PageInfo<User>(list);//把数据放在分页类中
        //封装数据
        model.addAttribute("list", list);
        //传分页类
        model.addAttribute("pageInfo", pageInfo);
        return "userList";//跳转页面
    }

}


