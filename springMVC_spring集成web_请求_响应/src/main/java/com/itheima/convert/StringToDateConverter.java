package com.itheima.convert;

import org.springframework.core.convert.converter.Converter;
import org.springframework.util.StringUtils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 自定义类型转换器：实现Convert接口
 *      将String类型的请求数据转换器Date类型
 */
public class StringToDateConverter implements Converter<String, Date> {

    /**
     * 自定义请求参数的转换格式
     * @param source
     * @return
     */
    public Date convert(String source) {
        if (StringUtils.isEmpty(source)){
           throw new RuntimeException("请输入请求参数值!");
        }
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = format.parse(source);//将string转换成date
        } catch (Exception e) {
            throw new  RuntimeException("自定义的数据类型转换出现异常！");
        }
        return date;
    }
}
