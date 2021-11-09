package com.itheima.mapper;

import com.itheima.domain.Account;
import com.itheima.domain.User;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;
import org.junit.After;

import java.util.List;

public interface AccountMapper {
    /**注解实现：查询账户信息，并且包含账户对应的用户信息；多对一查询
     *
     * @return
     */
    @Select("select * from account")
    //@Results注解：实现多个结果的封装
    @Results({
            //@Result注解：单个结果的封装
            @Result(id =  true,column = "id",property = "id"),
            @Result(column = "uid",property = "uid"),
            @Result(column = "money" ,property = "money"),
            //property属性：指定实体类中引用属性的名称，javaType属性：指定引用实体类类型,@One注解：实现一对一的结果封装
            @Result(property = "user", //property属性：指定实体类中引用属性的名称
                    javaType = User.class,//javaType属性：指定引用实体类类型,
                    column = "uid",//column属性：根据当前表中哪个字段，去查询关联表中的数据,实现多对一查询
                    //@One注解：实现一对一查询结果封装
                    one=@One(select = "com.itheima.mapper.UserMapper.selectOne",//select属性：指定调用哪个mapper接口中的哪个方法，
                            fetchType = FetchType.EAGER//fetchType属性：指定加载机制，EAGER表示立即加载，通过一对一选择立即加载
                    )
            )

    })
    public List<Account> findAccountAndUser();
    @Select("select * from account where uid=#{uid}")
    public List<Account> findById(Integer uid);
}
