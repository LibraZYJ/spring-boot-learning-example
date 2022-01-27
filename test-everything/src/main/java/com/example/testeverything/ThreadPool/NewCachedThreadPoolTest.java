package com.example.testeverything.ThreadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Yujie_Zhao
 * @date 2022/1/26 17:04
 * @deprecated 创建一个可缓存线程池，如果线程池长度超过处理需要，可灵活回收空闲线程，若无可回收，则新建线程。
 */

public class NewCachedThreadPoolTest {

    public static void main(String[] args) {
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            final int index = i;
            try {
                Thread.sleep(index * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            cachedThreadPool.execute(new Runnable() {

                @Override
                public void run() {
                    System.out.println("线程1 ：" + index);
                }
            });
            cachedThreadPool.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println("线程2 ：" + index);
                }
            });
        }
    }

}
