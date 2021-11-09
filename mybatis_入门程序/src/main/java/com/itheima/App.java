package com.itheima;

/**
 * Mybatis框架：基于java的持久成框架，内部封装了jdbc，开发者只需要关注sql语句本身，
 *              不需要花费大量精力去加载驱动，创建连接，创建statement等复杂的过程。
 *       mybatis通过xml配置文件或注解方式，将要执行的各种statement配置起来，通过java对象
 *       和statement中的sql动态将参数进行映射生成最终的要执行sql语句，最后由mybatis框架执行sql语句，
 *       并将结果映射java对象返回。
 *       ORM思想：
 *              mybatis采用ORM(Object Relationship Mapping)对象关系映射思想，就是数据持久化数据和实体类的映射模式。
 *       解决面向对象与关系型数据库存在的不匹配的现象技术
 *
 *      mybatis配置文件：
 *          1.包含数据库环境的配置
 *          2.指定mapper映射文件
 *          3.配置实体类别名
 *          4.引用外部jdbc.properties配置文件
 *
 *      dao接口：
 *          声明各种业务操作方法，
 *
 *      mapper映射配置文件：
 *          mybatis映射配置文件：
 *                   指定dao接口的位置和操作方法的位置
 *                   要执行的sql语句，
 *                  数据与对象之间的映射关系
 *
 *
 *      sqlSession构建者对象:
 *            执行sql
 *            事务管理:
 *              1.在sqlSessionFactory工厂开启sqlSession的时候就指定自动事务管理
 *              2.通过sqlSession.commmit()方法手动提交事务
 *            接口代理
 *              getMapper()
 *
 *       *获取插入数据自增长的id
 *              <selectKey></selectKey>标签
 *
 *       *<resultMap></resultMap>标签:建立实体类属性和表中字段对应关系，可以解决实体类属性和表中字段名不匹配的问题
 *
 *       *动态sql
 *              <if></>标签：用于条件判断
 *              <where></>标签：用于简化where 1=1的条件拼接
 *              <forEach></>标签：用于遍历集合，可以做批量插入操作
 *              <sql></sql>标签：提取重复的sql，<include></include>引用提取的重复sql
 */
public class App {
}
