package com.my.controller;

import com.my.service.TransferService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Controller
public class TransferController {

    @Resource
    TransferService transferService;

    /*使用AOP的事务管理项目*/
    @RequestMapping("aopTest")
     public String aopTest(){
         try {
             //执行A账户向B账户转账
             transferService.updateAOP();
             return "forward:/accountList";
         }catch (Exception e){
             return "forward:/accountList";
         }
     }

     /*未使用AOP的事务管理项目*/
    @RequestMapping("test")
    public String test(){
        try {
            //执行A账户向B账户转账
            transferService.noAOP();
            return "forward:/accountList";
        }catch (Exception e){
            return "forward:/accountList";

        }
    }

    //查看所有帐户信息
    @RequestMapping("accountList")
    public String getList(Model model){
        List<Map<String ,Object>> accountList=transferService.findAllAccount();
        model.addAttribute("accountList",accountList);
        return "accountList";
    }

    //返回首页
    @RequestMapping("back")
    public String goBack(){
        return "index";
    }
}
