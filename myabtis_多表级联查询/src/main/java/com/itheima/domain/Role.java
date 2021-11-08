package com.itheima.domain;

import com.itheima.domain.User;

import java.util.List;

public class Role {
    private Integer id;
    private String roleName;
    private String RoleDesc;
    //引用实体：一个角色可以有多个用户
    private List<User> users;

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleDesc() {
        return RoleDesc;
    }

    public void setRoleDesc(String roleDesc) {
        RoleDesc = roleDesc;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", roleName='" + roleName + '\'' +
                ", RoleDesc='" + RoleDesc + '\'' +
                ", users=" + users +
                '}';
    }
}
