package com.itheima;

import redis.clients.jedis.Jedis;

/**
 * RedisTemplate模板对象：Spring提供的模板对象用于操作Redis数据
 *      RedisTemplate模板操作数据方法：
 *          OpsForValue()----操作String类型的数据
 *          OpsForHash()----操作hash哈希类型的数据
 *          OpsForList()----操作list列表类型的数据
 *          OpsForSet()----操作set集合类型的数据
 *          OpsForSortedSet()----操作有序集合类型的数据
 *
 *
 *
 */
public class App {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("192.168.40.130",6378);
        jedis.set("name","itheima");
        jedis.close();
    }
}
