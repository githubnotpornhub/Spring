package com.my.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.my.entity.User;
import com.my.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
public class UserController {

    @Resource
    private UserService userService;

    /*向用户登录页面跳转*/
    @RequestMapping("loginView")
    public String toLogin(Model model) {
        model.addAttribute("msg", "您还没有登录，请先登录");
        return "login";
    }

    /*用户登录*/
    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String login( User user, Model model, HttpSession session) {
        //获取用户名和密码
        String username = user.getUsername();
        String password = user.getPassword();
        //模拟从数据库获取用户名和密码并进行判断
        if (username != null && username.equals("admin") &&
                password != null && password.equals("123")) {

            session.setAttribute("USER_SESSION", user);
            return "redirect:getInfo";
        }
        model.addAttribute("msg", "用户名或密码错误，请重新登陆");
        return "login";
    }

    /*向系统模拟主页面跳转*/
    @RequestMapping("home")
    public String toMain() {
        return "home";
    }

    /*查询用户信息（不分页）*/
    @RequestMapping("getAll")
    public String getAllUsers (Model model){
        List<Map<String,Object>> list=userService.selectAllUsers();
        model.addAttribute("list",list);
        return "userList";
    }

    /*查询用户信息（分页）*/
    @RequestMapping("pageSearch")
    public String getByPages(@RequestParam(name="page",defaultValue="1") Integer page,
                                     Model model){
        PageHelper.startPage(page, 5);//每页数据条数=5
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


    @RequestMapping("getInfo")
    public String getInfo() {
        return "getInfo";
    }



    /*退出登录*/
    @RequestMapping("logout")
    public String logout(HttpSession session) {
        //清除session
        session.invalidate();
        //重定向到用户登录页面
        return "redirect:loginView";
    }

}


