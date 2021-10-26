package config;

import config.postprocessor.MyBeanPostProcessor;
import config.selector.CustomerImportSelector;
import config.selector.MyImportSelector;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({MyImportSelector.class,CustomerImportSelector.class,MyBeanPostProcessor.class})//导入自定义组件导入器，
@ComponentScan(value = "com.itheima")
//按照自定的filter组件扫描过滤器实现，排除加载指定的bean
/*@ComponentScan(basePackages = "com.itheima",
        excludeFilters = @ComponentScan.Filter(
                type = FilterType.CUSTOM,       //使用自定义的组件扫描过滤器
                classes = MyTypeFilter.class    //指定组件扫描过滤器类的class对象
        )

)*/
/* //按照注解类型排除扫描指定的bean
@ComponentScan(
        value = "com.itheima",  //设置需要扫描的包路径
        excludeFilters =  @ComponentScan.Filter(    //排除过滤，排除指定的bean组件
            type = FilterType.ANNOTATION,   //排除类型：按照注解类型排除
                classes = Service.class     //设置具体的过滤项
        )

)*/


public class SpringConfig {
}
