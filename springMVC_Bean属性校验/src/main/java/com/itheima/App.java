package com.itheima;

/**
 * 校验框架：
 *    表单校验分类：
 *       校验位置：
 *          客户端校验：使用js技术，利用正则表达式对数据格式进行校验
 *          服务端校验：使用hibernate校验框架，对请求的参数的格式进行校验
 *    表单校验框架：
 *       jsr(Java Specification Requests)java规范提案
 *          *303：提供bean属性相关的校验
 *
 *       JCP(Java Community Process) java社区
 *
 *       校验框架：Hibernate校验框架：Hibernate-validator
 *          tomcat7 使用Hibernate 5.*版本
 *          tomcat8.5+ 使用Hibernate 6.*版本
 *
 *     校验使用：
 *      1.开启校验：
 *            @Valid注解：标注在控制器方法的pojo参数上，开启校验功能,不支持分组
 *            @Validated注解：开启分组校验
 *      2.Bean Validation规范内嵌的约束注解：
 *            @Null：验证属性是否为空
 *            @NotNull：验证属性是否非空，没有size的约束
 *            @NotEmpty：验证属性是否为非空，并且size>0
 *            @NotBlank：验证属性是否为非空，trim之后，size>0
 *
 *
 *            @AssertTrue：验证Boolean类型的属性是否为true
 *            @AssertFalse：验证Boolean类型的属性是否为false
 *
 *            @Max：验证Number类型和String类型的属性是否大于等于指定的值
 *            @Min：验证Number类型和String类型的属性是否小于等于指定的值
 *
 *            @Size：验证属性的长度是否在指定的范围内
 *
 *            @Past：验证Date类型或Calendar类型的属性是否在当前时间之前
 *            @Future：验证Date类型或Calendar类型的属性是否在当前之间之后
 *
 *            @Pattern：验证String类型属性是否符合正则表达式规则
 *
 *            @Email；验证String类型的属性是否为邮箱地址
 *
 *            @Valid：验证引用类型的属性
 *
 *              *message属性：指定验证错误时，提示的信息
 *      分组校验：新增和修改对实体的校验规则是不同，如新增是id要为空，修改是id不能为空
 *               都是对同一个实体类的属性进行校验，那么此时就要进行分组校验
 *          1.定义一个分组接口
 *          2.在属性的校验注解中指定groups属性，值为需要分组接口
 *          3.控制器方法参数前使用@Validated注解，指定分组的接口
 *
 *
 */
public class App {


}
