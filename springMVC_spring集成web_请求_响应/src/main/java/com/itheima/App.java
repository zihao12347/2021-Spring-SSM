package com.itheima;

/**
 * Spring集成web环境
 *      Spring的分层开发：数据层，业务层，视图层
 *     当视图层，需要调用业务层，就需要加载spring配置文件，初始化spring容器，获取bean组件使用
 *
 *     当如果有多个controller控制器，就需要加载多次配置文件，初始化spring容器
 *     解决方案：
 *          手动方式：通过监听器实现，
 *                  在每次web容器启动，加载配置文件，初始化spring容器，获取ApplicationContext应用上下文对象
 *                  再把ApplicationContext对象，存储到ServletContext域中，那么整个web环境，就能够调用service层的组件
 *          spring-web依赖包：spring集成了web环境；spring提供了一个ContextLoaderListener监听器，
 *                  该监听器，能够监听内部加载的spring配置文件，创建应用上下文，并存在到servletContext域中，
 *                  可以通过WebApplicationContextUtils工具类，去获取applicationContext对象
 *               实现方式：
 *                  1.导入spring-web依赖
 *                  2.在web.xml配置，配置ContextLoaderListener监听器
 *                  3.通过WebApplicationContextUtils工具类去获取spring的应用上下文对象
 *
 *
 * springmvc基础语法----见UserController类中
 *
 */
public class App {
}
