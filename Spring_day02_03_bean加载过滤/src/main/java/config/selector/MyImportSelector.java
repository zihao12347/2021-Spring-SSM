package config.selector;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

import java.util.ResourceBundle;

/**
 * 自定义的bean组件导入器：实现ImportSelector接口
 *
 */
public class MyImportSelector implements ImportSelector {

    /**
     * 导入bean组件方法
     * @param annotationMetadata
     * @return 返回值为一个数组；  放回值中定义的bean组件会自动导入到Spring的容器中
     */
    @Override
    public String[] selectImports(AnnotationMetadata annotationMetadata) {
       //使用ResourceBundle资源包，获取.properties配置文件中的信息
        ResourceBundle resourceBundle = ResourceBundle.getBundle("importselector");
        String className = resourceBundle.getString("className");
        String[] split = className.split(",");
        return split ;//指定需要导入的bean组件的全类名
    }
}
