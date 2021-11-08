package com.itheima.dao;

import com.itheima.domain.QueryVo;
import com.itheima.domain.Student;
import com.itheima.domain.Students;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * 基于代理Dao实现crud
 */
public class StudentDaoTest {
    /**Mybatis相关的API
     *    1.Resources:加载资源的工具类，
     *          GetResourceAsStream()方法，通过类加载器，返回指定资源的字节输入流。
     *              *相当于：通过 class.getClassLoader().getResourcesAsStream() 实现；
     *
     *    2.SqlSessionFactoryBuilder构建器：用于获取sqlSessionFactory工厂对象的构建器。
     *          build(InputStream is)方法:通过指定资源字节输入流获取sqlSession工厂对象。
     *
     *    3.SqlSessionFactory工厂对象：用于获sqlSession构建者对象
     *          方法：
     *              openSqlSession()获取sqlSession构建者方法，并开启手动提交事务。
     *              openSqlSession(Boolean b)获取sqlSession构建者方法，当参数为true时，表示开启自动事务
     *
     *    4.SlqSession构建者对象：用于执行sql,管理事务，接口代理
     *          方法：
     *            1.接口代理 :
     *              getMapper(Class<T>)方法，获取指定接口的代理类对象。
     *            2.事务管理：
     *              commit()提交事务
     *              rollback()回滚事务
     *           3.释放资源
     *             close()
     *           4.执行sql:
     *              selectList(statement,objectparamter)
     *              selectOne(statement,objectparamter)
     *              insert(statement,objectparamter)
     *              update(statement,objectparamter)
     *              delete(statement,objectparamter)
     *
  * @throws IOException
     */
    private InputStream resourceAsStream;
    private SqlSession sqlSession;

    /**
     * 测试方法初始化时配置
     */
    @Before
    public void init(){
        //1.加载mybatis配置文件
        //InputStream inputStream = Resources.getResourceAsStream("MybatisConfig.xml");
        ClassLoader classLoader = StudentDaoTest.class.getClassLoader();
         resourceAsStream = classLoader.getResourceAsStream("MybatisConfig.xml");

        //2.通过构造器创建sqlsession工厂对象
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        //4.使用工厂对象创建sqlsession对象
        sqlSession = factory.openSession(true);//并开启自动事务
    }

    /**
     * 测试根据学生名称模糊查询
     */
    @Test
    public void testFindByName(){
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        //Student student = mapper.findByName("%张%");
        List<Student> students = mapper.findByName("张");
        System.out.println(students);
    }

    /**
     * 测试：获取新增数据自增长的id
     */
    @Test
    public void testgetSaveId(){
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        Student student = new Student("老刘",38);
        System.out.println(student);
        mapper.save(student);
        System.out.println(student);
    }

    /**
     * 测试：使用pojo包装对象传入参数（pojo中包含pojo的参数）
     */
    @Test
    public void testPojoAsPar(){
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        QueryVo queryVo = new QueryVo();
        Student student = new Student();
        student.setId(1);
        queryVo.setStudent(student);
        Student byQueryVo = mapper.findByQueryVo(queryVo);
    }

    /**
     * 测试：实体类属性与数据库表的字段不匹配
     *      解决方案：在sql中使用 as 关键字，起别名，对查询结果字段进行再封装
     */
    @Test
    public void testByAs(){
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        Students students = mapper.findByAs(1);
        System.out.println(students);
    }

    /**
     * 测试：使用resultMap标签，建立表中的字段和实体类属性的对应关系
     */
    @Test
    public void testResultMap(){
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        Students students = mapper.findByResultMap(3);
        System.out.println(students);
    }

    /**
     * 查询所有学生
     * @throws IOException
     */
    @Test
    public void testSelectAll() throws IOException {
        //5.使用sqlsession创建dao接口的代理对象
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        //6.使用代理对象查询所有方法
        List<Student> students = mapper.selectAll();
        students.forEach(System.out::println);

    }

    /**
     * 根据学生id查询学生信息
     */
    @Test
    public void testSelectById(){
        //通过sqlSession构建者对象创建dao接口的代理对象
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        //调用代理对象的根据id查询方法
        Student student = mapper.selectById(1);
        System.out.println(student);
    }

    /**
     * 保存学生：
     *      并手动通过sqlSession构建者对象提交事务；
     */
    @Test
    public void testSave(){
        //通过sqlSession构建者对象创建dao接口的代理对象
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        //调用代理对象的保存方法
        Student student = new Student("老刘",38);
        mapper.save(student);
        //手动提交事务
        sqlSession.commit();
    }




    /**
     * 修改学生信息
     */
    @Test
    public void testUpdate(){
        //通过sqlSession构建者创建dao接口代理对象
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        Student student = new Student();
        student.setId(1);
        student.setName("张三");
        student.setAge(17);
        mapper.update(student);
    }

    /**
     * 测试删除学生
     */
    @Test
    public void testDelete(){
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        mapper.delete(5);
    }



    /**
     * 测试方法完成后配置
     * @throws IOException
     */
    @After
    public void destory() throws IOException {
        //释放资源
        sqlSession.close();
        resourceAsStream.close();
    }

}
