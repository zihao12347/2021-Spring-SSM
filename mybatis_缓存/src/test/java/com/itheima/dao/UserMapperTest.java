package com.itheima.dao;

import com.itheima.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class UserMapperTest {
    private InputStream resourceAsStream;
    SqlSessionFactory factory;
    SqlSession sqlSession;

    @Before
    public void init() throws IOException {
        //加载mybatis配置文件
        resourceAsStream = Resources.getResourceAsStream("MybatisConfig.xml");
        //通过sqlsessionfactory构建器创建sqlSession工厂对象
        factory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        //通过sqlSession工厂对象创建sqlSession构建者对象
        sqlSession = factory.openSession(true);//并开启自动事务
    }

    @After
    public void destory() throws IOException {
        //释放资源
        sqlSession.close();
        resourceAsStream.close();
    }
    @Test
    public void testFindAll(){
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> all = mapper.findAll();
        all.forEach(System.out::println);
    }

    /**
     * 测试mybatis中的一级缓存：sqlSession对象的缓存
     *          当执行增删改操作,commit(),close(),clearCache()一几缓存自动消失
     */
    @Test
    public void testOneLevelCache(){
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.findById(43);
        System.out.println(user);
        //clearCache()方法，清空sqlSession中的一级缓存
        sqlSession.clearCache();
        User user1 = mapper.findById(43);
        System.out.println(user1);
        System.out.println(user==user1);
    }

    /**
     * 测试mybatis中的二级缓存：二级缓存指mybatis中的sqlSessionFactory中的缓存
     *          由同一个selSessionFactory工厂创建sqlSession对象，共享缓存数据。
     *
     */
    @Test
    public void testTwoLevelCache(){
        SqlSession sqlSession = factory.openSession(true);
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.findById(43);
        System.out.println(user);
        sqlSession.close();//释放一级缓存

        SqlSession sqlSession2 = factory.openSession(true);
        UserMapper mapper2 = sqlSession2.getMapper(UserMapper.class);
        User user2 = mapper2.findById(43);
        System.out.println(user);
        sqlSession2.close();//释放一级缓存

        System.out.println(user==user2);//共享slqSessionFactory工厂中二级缓存的数据

    }

}
