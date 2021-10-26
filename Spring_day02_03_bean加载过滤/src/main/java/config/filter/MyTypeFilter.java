package config.filter;

import org.springframework.core.type.ClassMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;

import java.io.IOException;

/**
 * 自定义的组件扫描过滤器：实现排除扫描指定的bean注解
 *      实现TypeFilter过滤器接口
 */
public class MyTypeFilter implements TypeFilter {
    /**
     * 实现TypeFilter过滤器接口的抽象方法，自定义要过滤的组件
     * @param metadataReader    元素据对象
     * @param metadataReaderFactory 元数据工厂
     * @return  true,设置过滤。false默认值 不过滤
     * @throws IOException
     */
    @Override
    public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory) throws IOException {
        //根据metadataReader元素据对象获取所有的组件
        ClassMetadata classMetadata = metadataReader.getClassMetadata();//获取“类”元数据对象
        String className = classMetadata.getClassName();//获取所有组件的类名
        System.out.println(className);
        if ("com.itheima.service.impl.UserServiceImpl".equals(className)) {
            return true;//进行过滤，排除当前bean组件
        }
        return false;
    }
}
