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
    SqlSession sqlSession;

    @Before
    public void init() throws IOException {
        //加载mybatis配置文件
        resourceAsStream = Resources.getResourceAsStream("MybatisConfig.xml");
        //通过sqlsessionfactory构建器创建sqlSession工厂对象
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(resourceAsStream);
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
    @Test
    public void testFindById(){
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.findById(43);
        System.out.println(user);
    }

    @Test
    public void testFindUserAndAccount(){
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> userAndAccount = mapper.findUserAndAccount();
        userAndAccount.forEach(System.out::println);
    }
}
