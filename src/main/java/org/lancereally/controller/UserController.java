package org.lancereally.controller;

import com.alibaba.fastjson.JSON;
import org.hibernate.hql.spi.id.TableBasedDeleteHandlerImpl;
import org.lancereally.entity.Person;
import org.lancereally.entity.User;
import org.lancereally.util.DeepCloneUtil_Serial;
import org.lancereally.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.spring.web.json.Json;

import javax.annotation.Resource;
import java.io.IOException;

@RestController
public class UserController {

    @Resource
    RedisUtil redisUtil;
//    @Autowired
//    DeepCloneUtil_Serial deepCloneUtil_serial;
//记得开启redis
    @RequestMapping("/set")
    public String set(){
        //重写了Person类构造方法，需要一次性赋值所有
        Person person = new Person("","","","");
        person.setId("23333");
        User user = new User();
        user.setId(21);
        user.setName("lancereally");
        user.setPassword("130530xdf");
        user.setPerson(person);
        System.out.println(user);
        try {
            redisUtil.set("user1",user);
            redisUtil.set("user2",user);
            return "Redises Success";
        }catch (Exception e){
            e.printStackTrace();
            return "FAIL!";
        }
    }

    @RequestMapping("/get")
    public String get(){
        User user1 = (User) redisUtil.get("user1");
        User user2 = (User) redisUtil.get("user2");
        String str = JSON.toJSONString(user1);
        return str;
    }

//    @RequestMapping("/ShallowCopy")
//    public User ShallowCopy() throws CloneNotSupportedException{
//        System.out.println("浅拷贝start——");
////        Person person = new Person("","","","");
////        person.setId("23333");
////        User user = new User();
////        user.setId(21);
////        user.setName("lancereally");
////        user.setPassword("130530xdf");
////        user.setPerson(person);
//
//        //redis 会出错
//        /*已解决：
//        * 分析原因:redis的这些序列化方式,使用的是无参构造函数进行创建对象set方法进行赋值,
//        * 方法中存在有参的构造函数,默认存在的无参构造函数是不存在的(继承自object),
//        * 必须显示的去重写.
//        * */
//
//
//        User user = (User) redisUtil.get("user1");
//        User user3 = (User)user.clone();//返回类型为Object，需要强制转换
//        System.out.println("user1: "+user);
//        System.out.println("user3: "+user3);
//        System.out.println("(user1 == user3) ="+(user == user3));
//
//        //改变user3，进行一次二次浅拷贝的区分
//        System.out.println("改变user3，进行一次二次拷贝的区分");
//        user3.setId(12);
//        user3.getPerson().setId("32222");
//        System.out.println("user1: "+user);
//        System.out.println("user3: "+user3);
//
//        //变化的原因是:通过user执行clone时,基本类型会完全copy一份到user3对应对象内存空间中,
//        // 但是对于Person对象仅仅是copy了一份Person的引用而已.
//        if(user.getPerson().getId().equals(user3.getPerson().getId()))
//        System.out.println("可见两个User对象的Person字段仍指向同一块内存空间，浅拷贝无法实现完全复制");
//        return user3;
//    }
//
//    @RequestMapping("/ShallowCopy2")
//    public User ShallowCopy2() throws CloneNotSupportedException{
//        System.out.println("二次浅拷贝start——");
//        User user = (User) redisUtil.get("user1");
//        User user3 = (User)user.clone();//返回类型为Object，需要强制转换
//        System.out.println("user1: "+user);
//        System.out.println("user3: "+user3);
//        System.out.println("(user1 == user3) ="+(user == user3));
//
//        //改变user3，进行二次浅拷贝的区分
//        System.out.println("改变user3，进行二次浅拷贝的区分");
//        user3.setId(12);
//        user3.getPerson().setId("32222");
//        System.out.println("user1: "+user);
//        System.out.println("user3: "+user3);
//
//        if(!(user.getPerson().getId().equals(user3.getPerson().getId())))
//            System.out.println("可见所有成员类都重写Object.clone(),实现完全复制，但" +
//                    "成员类套娃的话需要一直覆写clone方法，因此需要深拷贝");
//        return user3;
//    }

    //深拷贝没有重写clone（），使用需要注释掉浅拷贝
    @RequestMapping("/DeepCopy")
    public User DeepCopy() throws IOException, ClassNotFoundException {
        //使用序列化完成深拷贝
        //深拷贝是利用对象流,将对象序列化,再反序列化得出新的对象. 因此首先需要实现实体类的序列化接口

        System.out.println("深拷贝start——");
        User user = (User) redisUtil.get("user1");
        User user3 = (User)DeepCloneUtil_Serial.cloneObject(user);//返回类型为Object，需要强制转换
        System.out.println("user1: "+user);
        System.out.println("user3: "+user3);
        System.out.println("(user1 == user3) ="+(user == user3));

        //改变user3，进行二次浅拷贝的区分
        System.out.println("改变user3内person字段的ID");
        user3.setId(12);
        user3.getPerson().setId("32222");
        System.out.println("user1: "+user);
        System.out.println("user3: "+user3);

        if(!(user.getPerson().getId().equals(user3.getPerson().getId())))
            System.out.println("深拷贝OK");
        return user3;
                /**
                 * clone方法:
                 优点:速度快,效率高
                 缺点:在对象引用比较深时,使用此方式比较繁琐

                 *通过序列化:
                 优点:非常简便的就可以完成深度copy
                 缺点:由于序列化的过程需要跟磁盘打交道,因此效率会低于clone方式*/
    }

    @RequestMapping("/schedual")
    public void Schedual(){

    }

}
