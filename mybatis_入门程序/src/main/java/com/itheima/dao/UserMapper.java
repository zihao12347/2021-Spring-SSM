package com.itheima.dao;

import com.itheima.domain.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface UserMapper {

    /**根据传入的查询条件进行查询，
     *
     * @param user 查询条件，当user实体的中属性值不为null，进行查询
     * @return
     */
    public List<User> findByCondition(User user);

    /**多条件同时查询
     *
     *      @Param注解:给参数命名，当多个参数需求传入sql中，必须使用@Param注解给这些参数命名，通过#{}占位符引用
     *      当只有一个参数时，可以不使用
     *
     * @param userName
     * @param gender
     * @return
     */
    public User findByPars(@Param("userName") String userName, @Param("gender") Integer gender);

    public void saveBatch(List<User> users);
}
