package com.itheima;

import redis.clients.jedis.Jedis;

/**Spring整合Redis:
 *      1.导入redis的依赖和jedis客户端依赖
 *      2.配置redis连接信息等,
 *      3装载redisTemplate模板组件到spring的容器中
 *      4.使用容器中RedisTemplate模板对象组件，
 *
 *
 *
 * RedisTemplate模板对象：Spring提供的模板对象用于操作Redis数据
 *      RedisTemplate模板操作数据方法：
 *          OpsForValue()----操作String类型的数据
 *          OpsForHash()----操作hash哈希类型的数据
 *          OpsForList()----操作list列表类型的数据
 *          OpsForSet()----操作set集合类型的数据
 *          OpsForSortedSet()----操作有序集合类型的数据
 */
public class App {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("192.168.40.130",6378);
        jedis.set("name","itheima");
        jedis.close();
    }
}
