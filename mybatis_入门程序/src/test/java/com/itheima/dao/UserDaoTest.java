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
import java.util.*;

public class UserDaoTest {
    private InputStream resourceAsStream;
    private SqlSession sqlSession;

    @Before
    public void init() throws IOException {
        //1.加载mybatis配置文件
        resourceAsStream = Resources.getResourceAsStream("MybatisConfig.xml");
        //2.构建sqlSessionFactory工厂
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        //3.开启sqlSession构建者对象
        sqlSession = sessionFactory.openSession(true);//开启自动事务管理


    }

    @After
    public void after() throws IOException {
        //是否资源
        sqlSession.close();
        resourceAsStream.close();
    }

    /**
     * 根据查询条件动态查询
     */
    @Test
    public void testFindByCondition() {
        //4.通过sqlSession构建者对象。创建dao接口的代理对象
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        //5.调用代理对象的方法
        User user = new User();
        //user.setUserName("Mike");
        user.setGender(1);
        List<User> userList = mapper.findByCondition(user);
        userList.forEach(System.out::println);
    }


    /**
     * 测试批量新增
     */
    @Test
    public void testSaveBatch(){
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> users = new ArrayList<>();
        Collections.addAll(users,new User("zihao","root",1,new Date())
                ,new User("LUCY","root",0,new Date()));
        mapper.saveBatch(users);
    }

    /**
     * 测试多条件查询
     */
    @Test
    public void testByPars(){
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.findByPars("Mike", 1);
        System.out.println(user);
    }
}
