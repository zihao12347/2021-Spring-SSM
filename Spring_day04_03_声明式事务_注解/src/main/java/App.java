import com.itheima.service.AccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Spring的事务管理：
 *      1.编程式的事务管理：通过API编写事务处理
 *      2.声明式的事务管理：在配置文件中配置相关的事务声明实现；
 *          1)通过XML配置文件配置
 *
 *          2)通过注解配置
 *              1.@Transaction注解：作用于接口（主流），类，方法上，对public方法进行事务管理
 *              2.配置事务管理器组件DatasourceTransactionManager
 *              3.开启事务注解支持<tx-annotation driven transaction-manager=""></tx-annotation>
 *
 *
 */
public class App {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        AccountService accountService = (AccountService) ctx.getBean("accountService");
        accountService.transfer("Mike","Jack",100D);
    }
}
