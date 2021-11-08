package com.itheima.domain;

import java.util.Date;

public class User {
    private Integer uuid;
    private String userName;
    private String password;
    private Integer gender;
    private Date birthday;

    public User() {

    }

    public User(String userName, String password, Integer gender, Date birthday) {
        this.userName = userName;
        this.password = password;
        this.gender = gender;
        this.birthday = birthday;
    }

    public User(Integer uuid, String userName, String password, Integer gender, Date birthday) {
        this.uuid = uuid;
        this.userName = userName;
        this.password = password;
        this.gender = gender;
        this.birthday = birthday;
    }

    public Integer getUuid() {
        return uuid;
    }

    public void setUuid(Integer uuid) {
        this.uuid = uuid;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "User{" +
                "uuid=" + uuid +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", gender=" + gender +
                ", birthday=" + birthday +
                '}';
    }
}
