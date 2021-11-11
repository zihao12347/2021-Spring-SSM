package com.itheima;

/**
 * mybatis缓存：
 *      缓存：存在内存中的临时数据：
 *      使用缓存的优点：
 *           减少与数据库的交互次数，提高执行效率。
 *       使用缓存的数据：
 *          经常查询的数据，并且不经常更改的数据
 *          数据的正确性对结果的影响不大的
 *        分类:
 *              一级缓存:
 *                  mybatis中sqlSession对象的缓存（开启sqlSession对象就存在的缓存）。
 *                  当执行查询结果后，会将查询结果保存在sqlSession的区域中，
 *
 *                  *该区域的结构为map，当再次执行相同的查询时，mybatis先从sqlSession缓存中查看是否有该查询结果，
 *                  有则直接取出查询结果。
 *
 *                  当执行commit()提交方法,clearCache()清除缓存方法，close()释放资源，
 *                  更新/删除/新增时，会清空sqlSession中的缓存
 *
 *              二级缓存（全局缓存）：
 *                  指定是sqlSessionFactory对象的缓存，
 *                  同一个sqlSessionFactory工厂对象开启的sqlSession对象，共享其二级缓存。
 *
 *                 *二级缓存中存放的数据为序列化后的数据，存放的不是对象。
 *
 *                *实现方式：
 *                   1.配置文件：
 *                      *.在mybatis配置文件中开启二级缓存支持(默认开启)
 *                      1.在mapper映射配置文件中开启缓存，
 *                          <cache></>
 *                      2.在select标签中开启缓存：
 *                          useCache属性为true
 *                   2.@CacheNamespace注解：在mapper接口上使用@CacheNamespace注解开启二级缓存
 *
 *
 *
 */
public class App {
}
