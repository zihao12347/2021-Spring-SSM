package com.itheima.domain;

import com.itheima.controller.GroupA;

import javax.validation.Valid;
import javax.validation.constraints.*;

public class Employee{



    @NotBlank(message = "分组校验：姓名不能为空!",groups ={ GroupA.class})//分组验证属性是否非空，trim之后，size>0
    private String name;//员工姓名

    @NotNull(message = "分组校验：年龄不能为空！",groups = {GroupA.class})
    @Max(value = 100,message = "年龄最大值不能超过100岁！")//验证年龄最大为100
    @Min(value = 0,message = "年龄最小值不能低于0岁！")//验证年龄最小为0
    private Integer age;//员工年龄


    @Valid//验证引用类的属性
    private Address address;//不进行分组校验

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", address=" + address +
                '}';
    }
}
