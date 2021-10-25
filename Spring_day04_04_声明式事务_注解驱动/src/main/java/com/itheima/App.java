package com.itheima;

/**
 * Spring的事务管理器：
 *        1.编程式的事务管理：通过API编程实现
 *        2.声明式的事物管理：通过在配置文件中配置相关事务的声明实现
 *              1.基于XML配置
 *              2.基于注解（全注解）
 *                  1.@Transactional注解（推荐在接口的方法上），开启事务管理
 *                  2.@EnableTransactionManagement注解：开启注解驱动
 *                  3.在配置类中装配平台事务管理器组件
 *
 */
public class App {
}
