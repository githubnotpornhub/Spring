package com.my.controller;

import com.my.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

@Controller
public class UserController {

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
            return "redirect:home";
        }
        model.addAttribute("msg", "用户名或密码错误，请重新登陆");
        return "login";
    }

    /*向系统模拟主页面跳转*/
    @RequestMapping("home")
    public String toMain() {
        return "home";
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
