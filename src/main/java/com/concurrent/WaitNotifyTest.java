package com.concurrent;

/**
 * Created by jiazhiwen on 2018/11/17.
 */
public class WaitNotifyTest {
    public static void main(String[] args) {
        final WaitNotifyTest lock = new WaitNotifyTest();
        new Thread(new Runnable(){
            @Override
            public void run() {
                synchronized (lock) {
                    try {
                        int i = 0;
                        while (i<100){
                            System.out.println(i);
                            lock.notify();
                            i=i+2;
                            lock.wait();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }
        }).start();

        new Thread(new Runnable(){
            @Override
            public void run() {
                synchronized (lock) {
                    try {
                        int i =1;
                        while (i<100){
                            System.out.println(i);
                            lock.notify();
                            i=i+2;
                            lock.wait();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }
        }).start();
    }
}
