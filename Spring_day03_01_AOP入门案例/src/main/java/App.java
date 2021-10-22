import com.itheima.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Aop(Aspect Oriented Programming)面向切面技术：将重复的代码抽取出来，
 *          在需要执行的时候，使用动态代理技术，在不修改源代码的基础上，对已有的方法进行增强。
 *       优势：
 *          提高代码的可重用性和方便维护
 *       Aop相关数术语：
 *          1.连接点JoinPoint：方法
 *          2.切入点PointCut: 对哪些连接点（方法）进行拦截的定义、
 *              切入点表达式：指定对哪些类的哪些方法进行增强
 *                  关键字(访问修饰符 返回值 包名.类名.方法名(参数))
 *                       * 通配符：任意代表单个
 *                      .. 通配符：任意代表多个
 *
 *
 *          4.通知Advice；拦截到的连接点需要做的事情，
 *              通知类型：
 *                  前置通知，原始方法执行之前执行
 *                  后置通知，原始方法执行之后执行
 *                  异常通知，原始方法出现异常执行
 *                  后置返回通知，原始方法执行正常执行之后执行
 *                  环绕通知：可以在代码中手动的控制增强方法执行的时间
 *                      增强方法：传入ProceedingJoinPoint对象，通过proceed()方法执行原始方法
 *
 *          3.切面AspectJ：切入点和通知的对应关系
 *          5.引介Introduction：在不修改源代码的基础上，为类动态的添加一些方法或者属性
 *          6.目标对象Target：需要代理的目标对象
 *          7.织入Weaving：将增强后的方法应用到目标对象，来创建新的代理对象的过程。
 *          8.代理Proxy：一个类被AOP织入增强后，产生的一个结果代理类
 *     在通知方法中获取原始方法的
 *          1.参数（任意类型通知）
 *                  在增强方法中指定一个JoinPoint对象，通过getArgs()方法获取所有的方法参数
 *          2.返回值（环绕通知，后置返回通知）
 *                  2.1环绕通知；
 *                      调用ProceedingJoinPoint对象的proceed()方法后自动返回一个结果，
 *                      并指定环绕通知的返回值
 *                  2.2后置返回通知
 *                      1.在配置中指定returning="返回值名称"属性
 *                      2.在增强中传入一个Object 返回值名称 参数，就可以获取到原始方法的返回值
 *          3.异常（环绕通知，异常通知）
 *                 3.1环绕通知：
 *                      直接在增强方法中处理异常
 *                 3.2异常通知
 *                       在配置中指定throwable属性
 *                      在方法中定义Throwable t 异常类参数，就可以获取异常信息
 *
 */
public class App {
    public static void main(String[] args) {

        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService userService = (UserService) ctx.getBean("userService");
        //userService.save(666);
        //userService.update();
        userService.delete();
    }
}
