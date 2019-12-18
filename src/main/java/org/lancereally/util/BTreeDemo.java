package org.lancereally.util;

import java.util.Scanner;

public class BTreeDemo {
    private BTreeDemo left,right;
    private char data;
    public BTreeDemo create(String des){
        System.out.println("摄取"+des);
        /**构造scanner*/
        Scanner scanner=new Scanner(System.in);
        String str=scanner.next();
        if(str.charAt(0) == '0')return null;//0作空使用
        /**数据处理*/
        BTreeDemo root=new BTreeDemo();
        root.data=str.charAt(0);
        root.left=create(str.charAt(0)+"左子树");
        root.right=create(str.charAt(0)+"右子树");
        return root;
    }
    public void firprint(BTreeDemo btree){
//        先序遍历
        if(btree!=null){
            System.out.print(btree.data+" ");
            firprint(btree.left);
            firprint(btree.right);
        }
    }
    public void midprint(BTreeDemo btree){
//        中序遍历
        if(btree!=null){
            midprint(btree.left);
            System.out.print(btree.data+"  ");
            midprint(btree.right);
        }
    }
    public void lastprint(BTreeDemo btree){
//        后序遍历
        if(btree!=null){
            lastprint(btree.left);
            lastprint(btree.right);
            System.out.print(btree.data+"  ");
        }
    }
    public static void main(String[] args) {
        BTreeDemo tree = new BTreeDemo();//工具树
        BTreeDemo newtree=tree.create("根节点");//生成的二叉树
        tree.firprint(newtree);
        System.out.println();
        tree.midprint(newtree);
        System.out.println();
        tree.lastprint(newtree);
    }
}
