package com.example.testeverything.threadDemo;

/**
 * @author Yujie_Zhao
 * @date 2022/1/20 14:53
 */
public class ThreadTest {

    public static void main(String[] args) {
        MyThread myThread  =  new MyThread();
        myThread.start();
    }

    public static  class  MyThread extends  Thread {
        @Override
        public  void  run() {
            System.out.println("MyThread");
        }
    }
}
