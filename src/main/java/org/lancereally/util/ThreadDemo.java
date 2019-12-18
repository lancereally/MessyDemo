package org.lancereally.util;

/**子线程循环3次，主线程接着循环1次，如此循环9次*/
public class ThreadDemo {
    final static int Reincarnation = 10;


    public static void main(String[] args) {
        MyThreads myThreads = new MyThreads();//实例化线程类
        //先启子线程,lambda表达式简化重写run方法
        new Thread(()->{
           for (int seq = 1;seq < Reincarnation;seq ++)
               myThreads.child(seq);
        }).start();

        //再起主线程
        new Thread(()->{
            for (int seq = 1;seq < Reincarnation;seq ++)
                myThreads.main(seq);
        }).start();
    }
}

//内部类
class MyThreads{
    static boolean flag = true;
//子线程
    public synchronized void child(int seq) {
        while(!flag){
            try {
                this.wait();
            }catch (Exception e){
                e.printStackTrace();
            }
        }

        for (int i = 1; i <= 3; i++) {
            System.out.println("child——" + seq + "-" + i);
        }
        flag = false; // 执行完修改标志
        this.notifyAll(); // 并唤醒别的线程
    }
    //主线程
    public synchronized void main(int seq) {
            while(flag){
                try {
                    this.wait();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }

            for (int i = 1; i <= 1; i++) {
                System.out.println("main——" + seq + "-" + i);
            }
            flag = true; // 执行完修改标志
            this.notifyAll(); // 并唤醒别的线程
    }

}