package com.leetcode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by jiazhiwen on 2019/3/26.
 */
public class Dota2Senate {
    public String predictPartyVictory(String senate) {
        Queue<Integer> rqueue = new LinkedList<>();
        Queue<Integer> dqueue = new LinkedList<>();
        int size = senate.length();
        for (int i = 0;i<size;i++) {
            if ("R".equals(String.valueOf(senate.charAt(i)))) {
                rqueue.add(i);
            }else {
                dqueue.add(i);
            }
        }
        while (true) {
            if (rqueue.isEmpty() || dqueue.isEmpty()) {
                return rqueue.isEmpty() ? "Dire" : "Radiant";
            }
            if (rqueue.peek() > dqueue.peek()) {
                dqueue.add(dqueue.peek() + size);
                dqueue.poll();
                rqueue.poll();
            }else {
                rqueue.add(rqueue.peek() + size);
                rqueue.poll();
                dqueue.poll();
            }

        }
    }


    public static void main(String[] args) {
        Dota2Senate dota2Senate = new Dota2Senate();
        String result = dota2Senate.predictPartyVictory("DRRDRDRDRDDRDRDR");
        System.out.println(result);

    }
}
