import com.itheima.domain.Account;
import com.itheima.service.AccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.PlatformTransactionManager;

/**
 * Spring中的事务管理:JavaEE体系进行分层开发,事务层处于在业务层中,
 *              Spring提供了对业务层的事务处理解决方案;
 *
 *     1.编程式的事务管理:使用API去实现对事务的管理
 *      1.PlatformTransactionManagement接口:平台事务管理器
 *          getTransaction()方法:获取事务状态信息
 *          commit():方法提交事务
 *          rollback()方法:回滚事务
 *        *DatasourceTransactionManagement实现类,适用于SpringJDBC和Mybatis
 *
 *          2.DefinitionTransaction接口:定义事务的信息
 *               getName()获取事务名称
 *              isReadOnly()是否只读
 *              getIsolationLevel()获取隔离级别
 *
 *         3.TransactionStatus接口:事务的执行状态
 *
 *     2.声明式的事务管理:通过AOP技术实现
 *          底层原理:将业务层的事务管理的功能抽取出来,制作成AOP通知,利用环绕通知,动态织入到目标对象方法中,
 *                  实现声明式的事务管理.
 *          1)基于XML配置实现
 *          2)基于注解实现
 */
public class App {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        AccountService accountService = (AccountService) ctx.getBean("accountService");
        //accountService.transfer("Mike","Jack",1000D);
        accountService.transferTwo("Mike","Jack",1000D);
    }
}
