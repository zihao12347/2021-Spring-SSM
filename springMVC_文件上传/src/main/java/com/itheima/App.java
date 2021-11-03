package com.itheima;

/**
 * 传统文件上传：
 *      通过解析request域对象，获取上传文件项
 *
 * SpringMVC实现文件上传：
 *   前提：
 *      1.依赖:
 *          commons-fileupload文件上传依赖
 *          commons-ioIO流依赖
 *
 *      2.页面：
 *          页面表单指定: enctype="multipart/form-data"属性,
 *                      并且请求方式为post
 *          input类型为file
 *      3.springMVC.xml配置文件：配置文件上传解析器
 *              配置CommonsMultipartResolver组件，可以配置上传文件的大小等。
 *
 *      4.控制器方法参数中，上传文件的类型为：MultipartFile，可以获取springMVC框架已解析的上传文件对象
 *
 *
 * 跨服务器方式文件上传：将文件上传到专门的文件存储服务器上
 *
 *      1.导入jersey相关依赖:
 *              jersey-core
 *              jersey-client
 *
 */
public class App {
}
