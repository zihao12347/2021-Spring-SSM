package com.itheima.mapper;

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

public class TestUserMapper {
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
    public void testFindAll(){
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> all = mapper.findAll();
        all.forEach(System.out::println);
    }
    @Test
    public void testFindByCondition(){
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> all = mapper.findByCondition("王","男");
        all.forEach(System.out::println);
    }
    @Test
    public void testDelete(){
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        boolean delete = mapper.delete(49);
        System.out.println(delete);
    }
    @Test
    public void testInsert(){
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = new User();
        user.setUsername("test");
        user.setAddress("test");
        user.setSex("男");
        user.setBirthday(new Date());
        boolean insert = mapper.insert(user);
        System.out.println(insert);
    }
    @Test
    public void testUpdate(){
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = new User();
        user.setId(50);
        user.setUsername("test002");
        user.setAddress("test");
        user.setSex("男");
        user.setBirthday(new Date());
        boolean update = mapper.update(user);
        System.out.println(update);
    }

    /**
     * 查询用户信息，并且包含用户下的所有账户信息，一对多查询
     */
    @Test
    public void testFindUserAndAccount(){
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> userAndAccount = mapper.findUserAndAccount();
        userAndAccount.forEach(System.out::println);
    }
}
