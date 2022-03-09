package com.itheima;

import com.alibaba.druid.pool.DruidDataSource;
import com.itheima.config.JDBCConfig;
import com.itheima.config.SpringConfig;
import com.itheima.dao.BookDao;
import com.itheima.dao.UserDao;
import com.itheima.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;

/**
 *  一：常用注解：
 *      1.创建bean组件的注解（4个）
 *          @Component
 *          @Service 业务层的注解
 *          @Repository 持久层的注解
 *          @Controller 视图层的组件
 *          作用：设置该类为spring管理的bean组件
 *
 *      2.注入数据的注解
 *          2.1注入引用类型：
 *            @Autowire 自动按类型注入
 *                 @Primary注解：按照类型注入时，该类优先注入
 *
 *            @Qualifier 先按照类型注入，再按照id注入，给属性注入时必须与@Autowire一起使用，给方法参数注入时可以单独使用
 *
 *            @Resource 自动按照bean的id注入
 *
 *          2.2基本类型和String类型
 *            @Value 注入基本类型和String类型给属性或者方法，通常用于将配置文件中的值，注入到属性中
 *
 *      3.改变bean作用范围的注解；
 *          @Scope注解， singleton单例(默认), prototype多例，request,session,global session
 *
 *      4.生命周期的注解：
 *          @PostConstruct 指定初始化方法
 *          @PreDestory 指定销毁化方法
 *
 *  二：spring纯注入配置
 *          1@Configuration注解：指定当前类是一个配置类
 *                获取容器时通过AnnotationConfigApplicationContext接口
*
 *          2.@ComponentScan注解：指定spring容器在初始化时需要扫描的包
 *
 *          3.@Bean注解：该注解只能用于在方法上，
 *                  表明该方法上的返回值，会注入到spring容器中
 *
 *         4.@propertiesResource("classpath:")注解导入外部配置文件，
 *
 *
 *         5.@import注解：导入其他配置类
 *
 *   三：bean的加载控制
 *          @DepensOn注解：当前组件需要依赖另一个组件，也就是@DependsOn注解指定的bean会比@Component指定的组件优先加载
 *                          可以配置在类和方法上
 *
 *          @Lazy注解：使当前bean组件延迟加载
 *
 *          @Order注解：指定配置类的加载顺序
 *
 *
 *
 *
 */
public class App {
    public static void main(String[] args) {
        //ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig.class, JDBCConfig.class);
        UserService userService = (UserService) ctx.getBean("userService");
        userService.save();

        UserDao userDao = (UserDao) ctx.getBean("userDao");
        //userDao.save();

        BookDao bookDao = (BookDao) ctx.getBean("bookDao");
        //bookDao.save();

        DruidDataSource druidDataSource =(DruidDataSource) ctx.getBean("druidDataSource");
        //System.out.println(druidDataSource);

        DataSource dataSource = (DataSource) ctx.getBean("druidDataSource");
        System.out.println(dataSource);
    }
}
