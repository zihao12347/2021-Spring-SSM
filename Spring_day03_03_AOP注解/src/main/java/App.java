import com.itheima.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 使用注解方式实现AOP：
 *    1.在配置文件中开启AOP注解支持
 *          <aop:aspectJ-autoProxy></aop:aspectJ-autoProxy>
 *
 *    2.注解配置：
 *       2.1@Aspect注解：配置切面,指定在类上；
 *       2.2@PointCut注解：配置切入点，指定在方法上；
 *          该方法是一个无参无返回值的方法
 *       2.3@Befor,@After,@Round,@AfterReturn,@AfterThrowing通知类型
 *
 *          *Order注解：指定多个相同通知类型的加载顺序
 *
 *     3.纯注解实现AOP：
 *          @EnableAspectJAutoProxy注解：
 *
 *
 *
 *
 */
public class App {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService userService = (UserService) ctx.getBean("userService");
        userService.save(666,888);
    }
}
