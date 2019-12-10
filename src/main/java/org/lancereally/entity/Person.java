package org.lancereally.entity;

import java.io.Serializable;

public class Person implements Serializable {
//通过实现序列化进行深拷贝 （可注释
    private String id;
    private String name;
    private String password;
    private String age;

    //序列号 （浅拷贝可注释
    private static final long serialVersionUID = 4477679176385287943L;

    //重写Object.clone方法,实现二次浅拷贝 （可注释
//    @Override
//    public Object clone() throws CloneNotSupportedException {
//        Person u = null;
//        try{
//            u = (Person)super.clone();
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//        return u;
//    }

    public Person(String id, String name, String password, String age) {
        super();
        this.id = id;
        this.name = name;
        this.password = password;
        this.age = age;
    }

    //为了redis序列化
    public Person(){

    }

//提供set和get方法

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", age='" + age + '\'' +
                '}';
    }
}
