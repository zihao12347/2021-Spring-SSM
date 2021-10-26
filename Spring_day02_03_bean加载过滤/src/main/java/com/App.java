package com;

import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;

/**
 * 一：组件扫描加载过滤器：
 *      在实际开发中，需要根据需求来加载必要的bean，排除指定的bean
 *      解决方案：@ComponentScan注解，设置组件扫描加载过滤器
 *
 *       excludedFilters属性：排除加载过滤
 *       includedFilter属性：包含加载过滤
 *
 *        type属性：设置过滤类型
 *              1.FilterType.ANNOTATION 按照注解类型排除
 *              2.自定义组件扫描过滤器
 *                  实现TypeFilter接口
 *
 *  二：组件导入；
 *         实现方式：
 *              1.通过在配置文件中使用<Bean></>标签导入
 *              2.通过@Component/@Controller/@Service/@Repository注解导入组件到Spring容器
 *
 *       在企业开发过程中，通常需要导入大量bean组件，需要一种快速导入大量bean组件的方式，
 *       解决方案：ImportSelector接口，
 *
 *       使用方式：
 *          在配置类中，使用@Import注解导入自定义的bean组件导入器
 *
 *
 *  三：自定义bean定义注册器，相当于自定义的@ComponentScan注解的功能，
 *          需要实现：ImportBeanDefinitionRegistrar接口
 *          功能:
 *          1.指定扫描哪些包路径下的组件
 *          2.添加自定义的组件加载过滤器
 *
 *          使用：
 *            在配置类中，使用@Import注解导入自定义的bean定义注册器
 *
 *  四：Bean的初始化，
 *      1.BeanFactoryPostProcessor接口，
 *          定义在bean工厂创建后，bean对象创建钱
 *
 *      3.BeanPostProcessor接口
 *          定义所有bean初始化前后的统一操作
 *
 *      2.InitializingBean接口,相当于配置文件中init-method属性和@PostConstructor注解的功能；
 *            定义在每个bean的初始化前的操作
 *
 *
 */
public class App {

}
