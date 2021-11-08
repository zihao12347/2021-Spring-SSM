package com.itheima.dao;

import com.itheima.domain.Role;

import java.util.List;

public interface RoleMapper {
    List<Role> findAll();

    /**
     * 查询角色信息，并且包含角色对应的用户信息：多对对查询
     * @return
     */
    List<Role> findRoleAndUser();
}
