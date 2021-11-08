package com.itheima.domain;

/**
 * 实体类和数据表字段名称不匹配
 */
public class Students {
    private Integer Sid;
    private String Sname;
    private Integer Sage;

    public Integer getSid() {
        return Sid;
    }

    public void setSid(Integer sid) {
        Sid = sid;
    }

    public String getSname() {
        return Sname;
    }

    public void setSname(String sname) {
        Sname = sname;
    }

    public Integer getSage() {
        return Sage;
    }

    public void setSage(Integer sage) {
        Sage = sage;
    }

    @Override
    public String toString() {
        return "Students{" +
                "Sid=" + Sid +
                ", Sname='" + Sname + '\'' +
                ", Sage=" + Sage +
                '}';
    }
}
