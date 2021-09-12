package com.my.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.List;
import java.util.UUID;

@Controller
public class FileUploadController {

    @RequestMapping("do")
    public String doUp() {
        return "fileUpload";
    }

    @RequestMapping("fileUpload")
    //@RequestParam：将请求参数绑定到你控制器的方法参数上（是springmvc中接收普通参数的注解）
    public String handleFileUpload(@RequestParam("name") String name,
                                   @RequestParam("uploadfile") List<MultipartFile> uploadfile,
                                   HttpServletRequest request) {
        //判断上传文件是否存在
        if (!uploadfile.isEmpty() && uploadfile.size() > 0) {
            //遍历上传文件
            for (MultipartFile file : uploadfile) {
                //获取上传文件的原始名
                String originalFilename = file.getOriginalFilename();
                //设置上传文件的保存目录
                String dirPath = request.getServletContext().getRealPath("/upload/");
                //可能是项目目录结构不一样，文件保存到target目录下fileupload../upload目录下去了
                File filePath = new File(dirPath);
                //如果保存文件的目录不存在。则先创建目录
                if (!filePath.exists()) {
                    filePath.mkdirs();
                }
                //使用通用唯一标识uuid重新命名上传的文件（上传人_uuid_原始文件名称）
                String newFilename = name + "_" + UUID.randomUUID() + "_" + originalFilename;
                try {
                    //使用MultipartFile接口的方法将文件上传到指定位置
                    file.transferTo(new File(dirPath + newFilename));
                } catch (Exception e) {
                    e.printStackTrace();
                    return "error";
                }
            }
            //跳转到成功页面
            return "success";
        } else {
            //跳转到失败页面
            return "error";
        }
    }
}
