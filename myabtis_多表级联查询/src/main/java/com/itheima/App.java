package com.itheima;

/**
 * Mybatis多表操作：
 *  多表模型：
 *      之前大多基于单表操作，实际开发中，大多都是随着业务的复杂，进行多表操作。
 *      多表模型分类：
 *          一对一：在任意一方建立外键 ，关联对方的主键。
 *          一对多：在多的一方建立外键，关联一的一方建立主键
 *          多对多：借助中间表，中间表最少两个自字段，分别关联两张的主键。
 *      一对一/多对一结果封装：
 *          <association></association>标签：用于建立多对一/一对一的映射关系
 *              property属性：指定引用的属性名称
 *              javaType属性：指定引用实体的类类型、
 *              autoMapping属性：是否完成自动映射
 *       多对多/一对多结果封装：
 *          <collection></collection>标签：用于建立多对多/一对多的映射关系
 *              property属性：指定引用的属性名称
 *              ofType属性；指定引用实体类的类型
 *              authMapping属性：是否完成自动映射
 *
 *
 *
 *
 *
 */
public class App {
}
