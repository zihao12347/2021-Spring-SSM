package com.itheima.dao;

import com.itheima.domain.User;
import org.apache.ibatis.annotations.*;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


public interface UserDao {

    @Insert(" insert into user (userName,password,realName,gender,birthday) values(#{userName},#{password},#{realName},#{gender},#{birthday})")
    public boolean save(User user);

    @Update("update user set userName=#{userName},password =#{password},realName=#{realName},gender=#{gender},birthday=#{birthday} where uuid=#{uuid}")
    public boolean update(User user);

    @Delete("delete  from user where uuid=#{uuid}")
    public boolean delete(Integer uuid);
    @Select("select * from user where uuid=#{uuid}")
    public User get(Integer uuid);
    @Select("select * from user")
    public List<User> getAll();
    @Select("select * from user where userName =#{userName} and password =#{password}")
    public User getByUsernameAndPassword(@Param("userName") String username, @Param("password") String password);

}
