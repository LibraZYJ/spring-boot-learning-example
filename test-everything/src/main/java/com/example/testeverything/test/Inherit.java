package com.example.testeverything.test;

import com.example.testeverything.test.Inherit.Fly;
import com.example.testeverything.test.Inherit.Run;

/**
 * @author Yujie_Zhao 多重继承的问题
 * @date 2022/1/19 9:14
 */
public class Inherit {

    public interface Fly {

        void fly();
    }

    public interface Run {
        void run();
    }
}

class Pit implements Fly, Run{

    @Override
    public void fly() {
        System.out.println("会飞的猪");
    }

    @Override
    public void run() {
        System.out.println("会跑的猪");
    }
}