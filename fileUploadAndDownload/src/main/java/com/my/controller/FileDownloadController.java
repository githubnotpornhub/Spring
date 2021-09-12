package com.my.controller;

import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.security.PublicKey;

@Controller
public class FileDownloadController {

    @RequestMapping("down")
    public String downLoad(){
        return "fileDownload";
    }

    /*以IO流方式进行文件下载*/
    @RequestMapping("fileDownload1")
    public void download(HttpServletRequest request, HttpServletResponse response,String filename){
        //定义IO流
        BufferedInputStream bis=null;
        BufferedOutputStream bos=null;

        //指定要下载的文件所在路径
        try {
            String path=request.getServletContext().getRealPath("/upload/");
            //创建该文件的对象
            File file=new File(path+File.separator+filename);
            //获取下载文件的长度
            long filelength=file.length();
            //对文件名进行编码，以防止因名称中的中文字符无法解析而产生乱码
            filename=this.getFilename(request,filename);
            //通知浏览器以下载的方式打开文件
            response.setContentType("application/x-msdownload;");
            //设置响应头信息
            response.setHeader("Content-disposition","attachment;filename="+filename);
            response.setHeader("Content-Length",String.valueOf(filelength));
            //以输入流打开文件
            bis =new BufferedInputStream(new FileInputStream(file));
            //获取响应的输出流
            bos=new BufferedOutputStream(response.getOutputStream());
            byte[]buff=new byte[2048];
            int bytesRead;
            //将文件内容写入响应的输出流
            while (-1!=(bytesRead=bis.read(buff,0,buff.length))){
                bos.write(buff,0,bytesRead);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (bis!=null)
                try {
                    bis.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            if (bos!=null)
                try {
                    bos.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
        }
    }

    /*以ResponseEntity方式进行文件下载*/
    @RequestMapping("fileDownload2")
    public ResponseEntity<byte[]>fileDownload(HttpServletRequest request,String filename)throws Exception{

        //指定要下载的文件所在路径
        String path=request.getServletContext().getRealPath("/upload/");
        //创建该文件对象
        File file=new File(path+File.separator+filename);
        //对文件名进行编码，以防止名称中的中文字符无法解析而产生乱码
        filename=this.getFilename(request,filename);
        //设置响应头信息
        HttpHeaders headers=new HttpHeaders();
        //通知浏览器以下载的方式打开文件
        headers.setContentDispositionFormData("attachment",filename);
        //定义以流的形式下载返回文件数据
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        //使用SpringMVC框架的ResponseEntity对象封装返回下载数据
        return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file),headers, HttpStatus.OK);
    }

    /*根据浏览器的不同进行编码设置，返回编码后的文件名*/
    private String getFilename(HttpServletRequest request, String filename) throws Exception {
        //IE不同版本User-Agent中出现的关键词
        String[] IEBrowserKeyWords={"MSIE","Trident","Edge"};
        //获取请求头代理信息
        String userAgent=request.getHeader("User-Agent");
        for (String keyWrod:IEBrowserKeyWords){
            if (userAgent.contains(keyWrod)){
                //IE内核浏览器统一以UTF-8编码显示
                return URLEncoder.encode(filename,"UTF-8");
            }
        }
        //火狐等其他浏览器统一以ISO-8859-1编码显示
        return new String(filename.getBytes("UTF-8"),"ISO-8859-1");
    }

}
