package com.itheima;

/**
 * mybatis延迟加载：
 *      在需要用到数据时才进行加载，不需要用到技术时就不加载。
 *
 *      优点：先从单表进行查询，需要时再从关联表，去关联表中查询，提高数据库性能。
 *            因为单表查询比多表查询速度快
 *      缺点：当大批量数据查询时，查询工作需要消耗时间，所有造成对用户体验感下降。
 *
 *
 *      通常一对多采用延迟加载，一对一/多对一采用立即加载；
 *
 *
 *      实现方式：
 *          1.在mybatis的配置文件中，配置全局的mybatis延迟加载:
 *          <settings>
 *              <setting name="lazyLoadingEnabled",value="true"></setting>
 *          </settings>
 *          2.在mapper映射文件，的association/collection标签中添加select属性：
 *                select属性：指定需要调用哪个接口中的哪个方法，实现延迟加载
 *                column属性：指定根据当前表中的哪个字段，去查询关联表的数据。
 *
 */
public class App {
}
