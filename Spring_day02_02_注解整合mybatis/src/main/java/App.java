import com.itheima.config.SpringConfig;
import com.itheima.domain.Account;
import com.itheima.service.AccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;

/**
 * spring注解整合mybatis
 *      1.使用@Runwith(SpringJunit4ClassRunner.class)替换原有的运行器
 *      2.使用@ContextConfiguration注解指定配置类或者配置文件的位置，用于初始spring化容器
 */
public class App {
    public static void main(String[] args) {
        //ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        ApplicationContext ctx=new AnnotationConfigApplicationContext(SpringConfig.class);
        DataSource dataSource =(DataSource) ctx.getBean("dataSource");
        //System.out.println(dataSource);
        AccountService accountService = (AccountService) ctx.getBean("accountService");
        Account ac = accountService.findById(2);
        System.out.println(ac);
    }
}
