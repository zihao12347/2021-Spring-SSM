package com.itheima;

/**前提：
 *      导入jackson依赖，实现json---pojo/集合数据之间的转换
 *
 * 异步请求传参：
 *      通过@RequestBody注解，获取请求体中内容绑定到控制器方法的形参中
 *
 *  异步请求响应：
 *      通过@ResponseBody注解，返回json格式的数据响应给客户端。
 *
 *  异步请求----跨域访问
 *      跨域：浏览器对javaScript的同源策略的限制。
 *          1.域名不同，
 *          2.端口不同
 *          3.请求协议不同
 *         跨域问题：浏览器对ajax请求的安全限制。
 *      解决跨域访问问题：使用@CrossOrigin注解实现；
 *          通过在控制器的方法上或者在控制器类上使用@CorsOrigin注解实现跨域问题
 */
public class App {

}
