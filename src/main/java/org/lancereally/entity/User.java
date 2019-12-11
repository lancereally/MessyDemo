package org.lancereally.entity;

import lombok.Data;

import java.io.Serializable;

@Data   //@Data : 注解在类上, 为类提供读写方法与构造方法, 此外还提供了 equals()、hashCode()、toString() 方法
public class User implements Serializable,Cloneable{
    //通过实现序列化进行深拷贝 （不可注释，此处有关redis缓存
    private int id;
    private String name;
    private String password;
    private Person person;

    //序列号 idea根据类的路径、参数、方法自动生成的64位哈希serialVersonUID （浅拷贝可注释
    private static final long serialVersionUID = 637519722946569204L;

    //重写Object.clone方法,否则只有Object对象能够clone （使用深拷贝可注释
//    @Override
//    public Object clone() throws CloneNotSupportedException {
//        User u = null;
//        try{
//            u = (User)super.clone();
//            //实现二次浅拷贝—— 可注释
//            Person p = (Person)this.person.clone();
//            u.setPerson(person);
//            //实现二次深拷贝——
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//        return u;
//    }

    //重写构造方法，一次赋值所有
//    public User(int id, String name, String password) {
//        this.id = id;
//        this.name = name;
//        this.password = password;
//    }

//有了@Data 不再需要以下
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
//
//    public Person getPerson() {
//        return person;
//    }
//
//    public void setPerson(Person person) {
//        this.person = person;
//    }
}
