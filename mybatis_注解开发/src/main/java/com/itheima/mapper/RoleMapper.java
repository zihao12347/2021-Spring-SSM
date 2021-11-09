package com.itheima.mapper;

import com.itheima.domain.Role;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

public interface RoleMapper {
    /**
     * 查询角色信息，并且包含角色对应所有用户信息；多对多查询
     */
    @Select("select * from role")
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "roleName",column = "rolename"),
            @Result(property = "RoleDesc",column = "Roledesc"),
            @Result(
                    property = "users",//当前实体类中的引用属性名
                    javaType = java.util.List.class,//引用类型的数据类型
                    column = "id",//根据当前表中的主键，查询中间标，和对应给关联表
                    //@Many注解：封装多对多/一对多的查询结果
                    many = @Many(
                            select ="com.itheima.mapper.UserMapper.findByRid"//select属性：指调用哪个接口中哪个方法
                            ,fetchType = FetchType.LAZY//开启延迟加载
                    )
            )

    })
    public List<Role> findRoleAndUser();

}
