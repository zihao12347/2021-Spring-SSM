package com.itheima;

/**
 * mybatis注解开发：
 *      使用mybatis提供的注解进行开发，能减少我们编写mapper映射文件。
 *   注解：
 *      @Select：查询
 *      @Insert：新增
 *      @Update：更新
 *      @Delete：删除
 *
 *      @Results：实现多个结果的封装
 *      @Result：实现结果封装
 *
 *      @One：实现一对一结果的封装
 *      @Many：实现多对多/一对多结果的封装
 *
 *      @CachenNameSpace注解：开启二级缓存
 *
 *      @Param注解：当mapper方法中的参数为多个时，需要使用@Param注解，给这些参数命名
 *
 *      *动态sql的拼装：
 *              使用<script></script>标签包裹住<if></if>标签，进行动态sql的拼装
 *
 *      *Mybatis中加载机制：
 *            当一对一/多对一查询时，通常采用立即加载
 *            当一对多/多对多查询时，通常采用延迟加载，按需进行加载，减少内存空间的占用。
 *
 *
 */
public class App {
}
