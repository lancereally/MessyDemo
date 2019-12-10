package org.lancereally.controller;

import com.alibaba.fastjson.JSON;
import org.lancereally.entity.User;
import org.lancereally.util.RedisUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.spring.web.json.Json;

import javax.annotation.Resource;

@RestController
public class UserController {

    @Resource
    RedisUtil redisUtil;
//记得开启redis
    @RequestMapping("/set")
    public String set(){
        User user = new User();
        user.setId(22);
        user.setName("lancereally");
        user.setPassword("130530xdf");
        System.out.println(user);
        redisUtil.set("user1",user);
        redisUtil.set("user2",user);
        return user.toString();
    }

    @RequestMapping("/get")
    public User get(){
        User user = (User) redisUtil.get("user1");
        User user1 = (User) redisUtil.get("user2");
        String str = JSON.toJSONString(user);
        return user;
    }





}
