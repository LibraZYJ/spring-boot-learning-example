package com.example.testeverything.threadDemo;

/**
 * @author Yujie_Zhao
 * @date 2022/1/25 10:37
 * 关键字 synchronized 的作用，相当于一个线程所锁，
 */
public class SynchronizedObjectLock implements Runnable {
    static SynchronizedObjectLock instence = new SynchronizedObjectLock();


    // 1. 手动指定锁定对象，也可以是this 也可以自定义的锁
//    @Override
//    public void run() {
//        synchronized (this) {
//            System.out.println("我是线程" + Thread.currentThread().getName());
//            try {
//                Thread.sleep(3000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            System.out.println(Thread.currentThread().getName() + "结束");
//        }
//    }


    // 2.  创建2把锁
//    Object block1 = new Object();
//    Object block2 = new Object();
//    @Override
//    public void run() {
//        // 这个代码块使用的是第一把锁，当他释放后，后面的代码块由于使用的是第二把锁，因此可以马上执行
//        synchronized (block1) {
//            System.out.println("block1锁,我是线程" + Thread.currentThread().getName());
//            try {
//                Thread.sleep(3000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            System.out.println("block1锁,"+Thread.currentThread().getName() + "结束");
//        }
//        synchronized (block2) {
//            System.out.println("block2锁,我是线程" + Thread.currentThread().getName());
//            try {
//                Thread.sleep(3000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            System.out.println("block2锁,"+Thread.currentThread().getName() + "结束");
//        }
//    }


    // 3. synchronized 修饰普通方法
    @Override
    public void run() {
        method();
    }
//    public synchronized void method() {
//        System.out.println("我是线程" + Thread.currentThread().getName());
//        try {
//            Thread.sleep(3000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        System.out.println(Thread.currentThread().getName() + "结束");
//    }



    static SynchronizedObjectLock instence1 = new SynchronizedObjectLock();
    static SynchronizedObjectLock instence2 = new SynchronizedObjectLock();
//    public synchronized void method() {

    /// synchronized用在静态方法上，默认的锁就是当前所在的Class类，所以无论是哪个线程访问它，需要的锁都只有一把
    public static synchronized void method() {
        System.out.println("我是线程" + Thread.currentThread().getName());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "结束");
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(instence1);
        Thread t2 = new Thread(instence2);
        t1.start();
        t2.start();
    }
}
