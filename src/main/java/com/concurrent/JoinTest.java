package com.concurrent;

/**
 * Created by jiazhiwen on 2018/11/17.
 */
public class JoinTest {
    public static void main(String[] args) {
        final Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000L);
                    System.out.println(1+Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"thread-1");

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    thread1.join();
                    System.out.println(2 + Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"thread-2");
        thread2.start();
        thread1.start();
    }
}
