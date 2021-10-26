package config.postprocessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * 自定义的bean初始化
 *      实现BeanPostProcessor接口，在所有bean对象初始化前后的操作
 */
public class MyBeanPostProcessor implements BeanPostProcessor{
    /**
     * bean初始前的操作
     * @param bean
     * @param beanName
     * @return
     * @throws BeansException
     */
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("BeanPostProcessor接口实现bean初始化前操作");
        return null;
    }

    /**
     * bean初始化后的操作
     * @param bean
     * @param beanName
     * @return
     * @throws BeansException
     */
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("BeanPostProcessor接口实现Bean初始化后的操作");
        return null;
    }
}
