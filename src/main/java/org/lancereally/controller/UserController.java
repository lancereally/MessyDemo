package org.lancereally.controller;

import org.lancereally.entity.User;
import org.lancereally.util.RedisUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
public class UserController {

    @Resource
    RedisUtil redisUtil;

    @RequestMapping("/set")
    public String set(){
        User user = new User(1,"tom","qwe");
        redisUtil.set("user1",user);
        redisUtil.set("user2",user);
        return "";
    }

    @RequestMapping("/get")
    public String get(){
        User user = (User) redisUtil.get("user1");
        User user1 = (User) redisUtil.get("user2");
        return "";
    }





}
