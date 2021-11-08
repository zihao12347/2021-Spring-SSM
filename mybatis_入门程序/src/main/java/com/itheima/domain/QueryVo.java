package com.itheima.domain;

/**
 * pojo中包含pojo作为查询参数
 */
public class QueryVo {
    private Student student;

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "QueryVo{" +
                "student=" + student +
                '}';
    }
}
