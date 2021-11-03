package com.itheima.controller;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

/**
 * 文件上传控制器
 */
@Controller
@RequestMapping("/file")
public class FileuploadController {
    /**
     * 传统方式获取上传的文件：
     *              通过解析request域对象实现（所有的请求参数都会保存在request域中）
     * @param request
     * @return
     */
    @RequestMapping("/uploadOne")
    public String fileupoad(HttpServletRequest request) throws Exception {
        System.out.println("文件上传!");
        //获取/upload/文件夹部署在应用的绝对磁盘路径
        String realPath = request.getSession().getServletContext().getRealPath("/upload/");
        System.out.println(realPath);
        File file = new File(realPath);
        if (!file.exists()) {//判断该文件夹是否存在
            file.mkdir();//不存在，创建该文件夹
        }
        //解析request域对象，获取文件上传项
        DiskFileItemFactory fileItemFactory=new DiskFileItemFactory();
        ServletFileUpload upload= new ServletFileUpload(fileItemFactory);
        List<FileItem> fileItems = upload.parseRequest(request);//解析request域对象获取上传文件项
        for (FileItem fileItem : fileItems) {//遍历上传文件项
            //判断该文件项是是否为上传文件项，
            if (fileItem.isFormField()) {//当前文件项为普通表单项

            }else {//上传文件项
                String fileItemName = fileItem.getName();//获取上传文件名称
                String replace = UUID.randomUUID().toString().replace("-", "");//使用""替换-
                String ufilename = replace + "_" + fileItemName;//对每个上传的文件都生成一个唯一的文件名称
                fileItem.write(new File(realPath,ufilename));//将上传的文件保存在指定位置中
                fileItem.delete();//删除临时的上传文件
            }
        }
        return "/success.jsp";
    }


    /**SpringMVC方式的文件上传
     *
     * @param file MultipartFile 上传文件类型，获取springMVC框架已经解析request域对象中的上传文件项
     * @return
     */
    @RequestMapping("/mvcupload")
    public String mvcFileUpload(MultipartFile file,HttpServletRequest request) throws Exception {
        System.out.println("文件上传!");
        //获取/upload/文件夹部署在应用的绝对磁盘路径
        String realPath = request.getSession().getServletContext().getRealPath("/upload/");
        File f = new File(realPath);
        if (!f.exists()) {//判断该文件夹是否存在
            f.mkdir();//不存在，创建该文件夹
        }
        String originalFilename = file.getOriginalFilename();//获取上传文件的文件名称
        String replace = UUID.randomUUID().toString().replace("-", "");
        String ufilename = replace + "_" + originalFilename;
        file.transferTo(new File(f, ufilename));//transferTo()方法将文件保存到指定的位置中
        return "/success.jsp";
    }

    @RequestMapping("/acrossServerFileupload")
    public String acrossServerFileupload(MultipartFile file) throws IOException {
        System.out.println("跨服务器方式文件上传！");
        String filename = file.getOriginalFilename();//获取文件名称
        String uuid = UUID.randomUUID().toString().replace("-", "");
        String ufilename = uuid + "_" + filename;//生成唯一的文件名称

        //定义上传文件的服务器路径
        String path="http://localhost:8090/fileupload_server_war_exploded/uploads/";
        //创建客户端对象
        Client client = Client.create();
        //和图片服务器进行连接
        WebResource webResource = client.resource(path + ufilename);
        //上传文件到图片服务器
        webResource.put(file.getBytes());
        return "/success.jsp";
    }
}
