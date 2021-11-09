package com.itheima.mapper;

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
import java.util.Date;
import java.util.List;

public class TestRoleMapper {
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

    /**
     *查询角色信息：并且包含角色对应的所有用户信息：多对多查询
     */
    @Test
    public void findRoleAndUser(){
        RoleMapper mapper = sqlSession.getMapper(RoleMapper.class);
        List<Role> roleList = mapper.findRoleAndUser();
        roleList.forEach(System.out::println);
    }

}
