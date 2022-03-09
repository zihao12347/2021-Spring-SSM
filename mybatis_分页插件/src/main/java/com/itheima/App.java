package com.itheima;

/**
 * mybatis分页查询：
 *    使用步骤：
 *      1.引入pagehelper分页插件:
 *              hegahelper依赖
 *      2.1在mybatis配置文件在配置:
 *              <plugins>
 *                  <plugin interceptor="om.github.pagehelper"></plugin>
 *              </plugins>
 *      2.2当spring整合mybatis时，
 *              在sqlsessionfactorybean中配置分页查询拦截器
 *        <property name="plugins">
 *             <array>
 *                 <!--配置mybatis的分页插件-->
 *                 <bean class="com.github.pagehelper.PageInterceptor">
 *                     <property name="properties">
 *                         <props>
 *                             <prop key="helperDialect">mysql</prop>
 *                             <prop key="reasonable">true</prop>
 *                         </props>
 *                     </property>
 *                 </bean>
 *             </array>
 *         </property>
 *
 *      3.使用hegehelper的API进行分页查询
 *          1.PageHelper分页助手功能类：
 *                startPage(currentPage ,size)设置分页查询参数，currentPage：当前页码，size 每页显示的数量
 *          2.Page分页查询结果封装类: 使用Page类，来封装查询结果
 *
 *              常用方法：
 *                  getTotal()返回总记录数
 *                  getResult()返回查询结果集
 *                  getPages()返回总页数
 *
 *          3.PageInfo：分页参数类
 *               常用方法：
 *                getTotal()获取总记录数
 *                getPages()获取总页数
 *                getPageNum()获取当前页码
 *                getPageSize()获取每页显示的条数
 *
 *
 */
public class App {
}
