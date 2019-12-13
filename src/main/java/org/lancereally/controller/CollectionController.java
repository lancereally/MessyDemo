package org.lancereally.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@RestController
public class CollectionController {

    @RequestMapping("/arraylist")
    public String List(){
        List<Integer> list = new ArrayList<Integer>();
        list.add(0,1);//定位添加
        list.add(2);//添加
        list.set(1,3);//修改
        System.out.println("List集合第一个元素"+list.get(0));
        System.out.println("List大小 = "+list.size());
        //迭代器遍历
        System.out.println("————————————");
        System.out.println("迭代器遍历");
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()){
            int next = iterator.next();
            System.out.println(next);
        }
        //for遍历
        System.out.println("————————————");
        System.out.println("for循环遍历");
        for (int forr : list)
            System.out.println(forr);
        //判断
        System.out.println("————————————");
        System.out.println("judge");
        boolean result = list.isEmpty();//是否为空
        System.out.println("list.isEmpty() ="+result);
        result = list.contains(3);//是否包含
        System.out.println("list.contains(3) ="+result);

        //转换为数组(存储int无法使用.toArray(),只能利用.size()创建同大小的int数组，通过for进行一一存值)
        /**int[] intArray = list.toArray(new int[]{});*/

        //删除
        System.out.println("————————————");
        System.out.println("delete");
        list.remove(1);
        System.out.println("执行list.remove(1)——");
        System.out.println("list.contains(1) = "+list.contains(3));
        list.clear();
        System.out.println("执行list.clear()——");
        System.out.println("list.size() = "+list.size());
        return "Congratulation！ ——<[ArrayList Killer!]>——";
    }

    @RequestMapping("/linkedlist")
    public String list(){
        List<String> linkedList = new LinkedList<String>();
        System.out.println("LinkedList初始容量："+linkedList.size());

        //添加功能：
        linkedList.add("PNISHING ?!");
        linkedList.add("what");
        linkedList.add("the");
        linkedList.add("fuck");
        linkedList.add("game?!");
        System.out.println("LinkedList当前容量："+ linkedList.size());

        //修改功能:
        linkedList.set(0,"hello");
        linkedList.set(1,"world");
        System.out.println("LinkedList当前内容："+ linkedList.toString());

        //获取功能：
        String element = linkedList.get(0);
        System.out.println(element);

        //遍历集合：(LinkedList实际的跌倒器是ListItr对象)
        Iterator<String> iterator =  linkedList.iterator();
        while(iterator.hasNext()){
            String next = iterator.next();
            System.out.println(next);
        }
        //for循环迭代集合：
        for(String str:linkedList){
            System.out.println(str);
        }

        //判断功能：
        boolean isEmpty = linkedList.isEmpty();
        boolean isContains = linkedList.contains("jiaboyan");

        //长度功能：
        int size = linkedList.size();

        //删除功能：
        linkedList.remove(0);
        linkedList.remove("jiaboyan");
        linkedList.clear();
        System.out.println("LinkedList当前容量：" + linkedList.size());
        return "Congratulation！ ——<[LinkedList Killer!]>——";
    }
}
