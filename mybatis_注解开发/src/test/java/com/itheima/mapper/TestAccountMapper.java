package com.itheima.mapper;

import com.itheima.domain.Account;
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
import java.util.Date;
import java.util.List;

public class TestAccountMapper {
    private InputStream resourceAsStream;
    private  SqlSession sqlSession;
    @Before
    public void init() throws IOException {
        //1.加载配置文件
        resourceAsStream = Resources.getResourceAsStream("mybatisConfig.xml");
        //2.通过sqlsessionfactory构建器构建sqlsession工厂
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        //3.通过sqlSession工厂开启sqlSession构建者对象
        sqlSession = factory.openSession(true);//开启自动提交事务
    }
    @After
    public void destroy() throws IOException {
        //释放资源
        sqlSession.close();
        resourceAsStream.close();
    }

    @Test
    public void testUpdate(){
        AccountMapper mapper = sqlSession.getMapper(AccountMapper.class);
        List<Account> accountAndUser = mapper.findAccountAndUser();
        accountAndUser.forEach(System.out::println);
    }

    /**
     * 查询账户信息，并且包含账户下的用户信息，多对一查询
     */
    @Test
    public void testFindUserAndAccount(){
        AccountMapper mapper = sqlSession.getMapper(AccountMapper.class);
        List<Account> accountAndUser = mapper.findAccountAndUser();
        accountAndUser.forEach(System.out::println);
    }
}
