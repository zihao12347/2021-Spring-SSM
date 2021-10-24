import com.itheima.service.AccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Spring的事务管理:
 *      1.编程式的事务管理:通过API编写事务处理
 *
 *      2.声明式的事物管理:通过在配置文件中配置事务的相关声明实现,
 *          实现原理:通过AOP技术实现的
 *              将业务层处理事务的功能抽取出来,值作成通知,再动态的织入到目标对象的方法中
 *          2.1基于XML配置方式实现:
 *              1.配置事务管理器组件
 *              2.配置tx-advice事务通知
 *                      method属性:指定对哪里方法拦截进行事务管理
 *              3.配置aop,<aop:advisor>标签定义事务通知和切入点的对于关系
 *
 *
 *          2.2基于注解方式实现
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
