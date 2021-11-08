package com.itheima.dao;


import com.itheima.domain.QueryVo;
import com.itheima.domain.Student;
import com.itheima.domain.Students;

import java.util.List;
import java.util.Queue;

public interface StudentMapper {
    public List<Student> selectAll();
    public Student selectById(Integer id);
    public void save(Student student);
    public void update(Student student);
    public void delete(Integer id);
    public List<Student> findByName(String name);
    public Student findByQueryVo(QueryVo queryVo);
    public Students findByAs(Integer sid);
    public Students findByResultMap(Integer id);
}
