package org.lancereally.util;

import java.util.ArrayList;
import java.util.List;

public class BTreeDemo_2 {
    public BTreeDemo_2 left;
    public BTreeDemo_2 right;
    public BTreeDemo_2 root;
    //    数据域
    private Object data;
    //    存节点
    public List<BTreeDemo_2> datas;
    /**构造方法 1，三参*/
    public BTreeDemo_2(BTreeDemo_2 left, BTreeDemo_2 right, Object data){
        this.left=left;
        this.right=right;
        this.data=data;
    }
    /**构造方法 2，单参*/
    //    将初始的左右孩子值为空
    public BTreeDemo_2(Object data){
        this(null,null,data);
    }
    /**构造方法 3，无参*/
    public BTreeDemo_2() {

    }

    public String creat(Object[] objs){
        if(objs.length < 1){
            System.out.println("恁给的是个锤子数据？？？");
            return "?";
        }

            datas=new ArrayList<BTreeDemo_2>();
        //        将一个数组的值依次转换为Node节点
        for(Object o:objs){
            datas.add(new BTreeDemo_2(o));
        }
//        第一个数为根节点
        root=datas.get(0);
//        建立二叉树
        for (int i = 0; i <objs.length/2; i++) {
//            左孩子
            datas.get(i).left=datas.get(i*2+1);
//            右孩子
            if(i*2+2<datas.size()){//避免偶数的时候 下标越界
                datas.get(i).right=datas.get(i*2+2);
            }
        }
        return "";
    }
    //先序遍历
    public void preorder(BTreeDemo_2 root){
        if(root!=null){
            System.out.print(root.data+" ");
            preorder(root.left);
            preorder(root.right);
        }
    }
    //中序遍历
    public void inorder(BTreeDemo_2 root){
        if(root!=null){
            inorder(root.left);
            System.out.print(root.data+" ");
            inorder(root.right);
        }
    }
    //    后序遍历
    public void afterorder(BTreeDemo_2 root){
        if(root!=null){
            System.out.print(root.data+" ");
            afterorder(root.left);
            afterorder(root.right);
        }
    }
    public static void main(String[] args) {
        BTreeDemo_2 bt=new BTreeDemo_2();
        Object []a={'A','B','C','d','e'};//完全二叉树
        bt.creat(a);
        bt.preorder(bt.root);
    }
}
