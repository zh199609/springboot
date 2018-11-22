package com.zl.entity;

import javax.annotation.Generated;
import javax.persistence.*;
import java.io.Serializable;

//配置映射关系  使用JPA注解
//告诉JPA这是一个实体类 和数据表映射
@Entity
//省略 默认类名小写
@Table(name = "user")
public class User implements Serializable {

    @Id//这是主键
    @GeneratedValue(strategy = GenerationType.IDENTITY)//自增主键
    private Integer id;
    @Column(name = "last_name", length = 50)
    private String lastName;
    @Column(name = "email", length = 50)
    private String email;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
