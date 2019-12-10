package org.lancereally.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Data   //@Data : 注解在类上, 为类提供读写方法与构造方法, 此外还提供了 equals()、hashCode()、toString() 方法
public class User implements Serializable {
    private int id;
    private String name;
    private String password;


    //有了@Data 不再需要以下
//    public User(int id, String name, String password) {
//        this.id = id;
//        this.name = name;
//        this.password = password;
//    }
//
//    public User(){
//
//    }
//
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
}
