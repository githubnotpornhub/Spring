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

    /*ʹ��AOP�����������Ŀ*/
    @RequestMapping("aopTest")
     public String aopTest(){
         try {
             //ִ��A�˻���B�˻�ת��
             transferService.updateAOP();
             return "forward:/accountList";
         }catch (Exception e){
             return "forward:/accountList";
         }
     }

     /*δʹ��AOP�����������Ŀ*/
    @RequestMapping("test")
    public String test(){
        try {
            //ִ��A�˻���B�˻�ת��
            transferService.noAOP();
            return "forward:/accountList";
        }catch (Exception e){
            return "forward:/accountList";

        }
    }

    //�鿴�����ʻ���Ϣ
    @RequestMapping("accountList")
    public String getList(Model model){
        List<Map<String ,Object>> accountList=transferService.findAllAccount();
        model.addAttribute("accountList",accountList);
        return "accountList";
    }

    //������ҳ
    @RequestMapping("back")
    public String goBack(){
        return "index";
    }
}
