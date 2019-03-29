package com.leetcode;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by jiazhiwen on 2019/2/17.
 */
public class ListNodeSwap {
    static StringOrder stringOrder = new StringOrder(9L);


    public void add(Integer a){
        int b= a;
        b++;

    }
    public static void main(String[] args) {
       ListNodeSwap listNodeSwap = new ListNodeSwap();
       Thread thread = new Thread(new testAtomicLong());
       Thread thread1 = new Thread(new testAtomicLong());
       Thread thread2= new Thread(new testAtomicLong());
       Thread thread3 = new Thread(new testAtomicLong());
       Thread thread4 = new Thread(new testAtomicLong());
       Thread thread5 = new Thread(new testAtomicLong());
        thread.start();
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
        //System.out.println(stringOrder.getValue());

    }

    public static class testAtomicLong implements Runnable{
        @Override
        public void run() {
            long a = stringOrder.getValue();
            stringOrder.setValue(stringOrder.getValue());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            AtomicLong atomicLong = new AtomicLong(stringOrder.getValue());
            boolean stag = atomicLong.compareAndSet(9L, 91L);
            System.out.println(stag);
            stringOrder.setValue(atomicLong.get());
            System.out.println(stringOrder.getValue());
        }
    }
    public ListNode swapPairs(ListNode head) {
        if(head.next==null){
            return head;
        }
        ListNode preNode = head;
        ListNode node = head.next;
        head = node;
        int i = 2;
        while(node!=null){
            if(i%2==0){
                preNode.next = node.next;
                node.next = preNode;
                preNode = node.next;
                node = preNode.next;
            }else{
                preNode = preNode.next;
                node = node.next;
            }
            i++;

        }
        return head;
    }

    /*public static void main(String[] args) {
        ListNodeSwap listNodeSwap = new ListNodeSwap();
        ListNode listNode = new ListNode(1);
        listNode.next=(new ListNode(2));
        listNode.next.next=(new ListNode(3));
        listNode.next.next.next=(new ListNode(4));
        listNodeSwap.swapPairs(listNode);
    }*/
    static class ListNode {
             int val;
            ListNode next;
            ListNode(int x) { val = x; }
         }
}
