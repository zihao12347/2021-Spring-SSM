package com.itheima.mapper;

import com.itheima.domain.User;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

public interface UserMapper  {
    @Select("select * from user")
    public List<User> findAll();
    @Insert("insert into user (username,birthday,sex,address)values(#{username},#{birthday},#{sex},#{address})")
    public boolean insert(User user);
    @Update("update user set username=#{username},birthday=#{birthday},sex=#{sex},address=#{address} where id=#{id}")
    public boolean update(User user);
    @Delete("delete from user where id=#{id}")
    public boolean delete(Integer id);
    /*@Select("select * from user where username like #{username} and sex = #{sex}")*/
    @Select("select * from user where username like '%${username}%' and sex = #{sex}")
    public List<User> findByCondition(@Param("username") String username,@Param("sex") String sex);
    @Select("select * from user where id=#{uid}")
    public User selectOne(Integer uid);

    /**注解实现：查询用户，并且包含用户下所有的账户信息：一对多查询
     *
     * @return
     */
    @Select("select * from  user")
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "username",column = "username"),
            @Result(property = "birthday",column = "birthday"),
            @Result(property = "sex",column = "sex"),
            @Result(property = "address",column = "address"),
            @Result(
                    property = "accounts",//property:当前实体类中，引用类型的属性名
                    column = "id",//column属性：表示根据当前表中哪个字段，查询关联表中的数据，实现一对多查询
                    javaType = java.util.List.class,//引用的数据型
                    //@Many注解：实现一对多/多对多的结果封装
                    many = @Many(select = "com.itheima.mapper.AccountMapper.findById"//select:指调用哪个接口中哪个方法
                            ,fetchType = FetchType.LAZY
                    )//一对多/多对多通常采用延迟加载机制
            )
    })
    public List<User> findUserAndAccount();

    @Select("select * from user u,user_role ur where u.id =ur.uid and ur.rid =#{rid} ")
    public List<User> findByRid(Integer rid);
}
