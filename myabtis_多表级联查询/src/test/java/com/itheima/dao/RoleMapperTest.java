package com.itheima.dao;

import com.itheima.domain.Role;
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

public class RoleMapperTest {
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
        RoleMapper mapper = sqlSession.getMapper(RoleMapper.class);
        List<Role> all = mapper.findAll();
        all.forEach(System.out::println);
    }

    /**
     *查询角色信息，并且包含角色对应的用户:多对多查询
     */
    @Test
    public void testFindRoleAndUser(){
        RoleMapper mapper = sqlSession.getMapper(RoleMapper.class);
        List<Role> roleAndUser = mapper.findRoleAndUser();
        roleAndUser.forEach(System.out::println);
    }

}
