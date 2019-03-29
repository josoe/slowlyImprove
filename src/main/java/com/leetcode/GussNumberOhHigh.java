package com.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by jiazhiwen on 2019/3/27.
 */
public class GussNumberOhHigh {
    public int guessNumber(int n) {
        return guessNumber(n / 2, 0, n);
    }

    int guessNumber(int mid,int start,int end) {
        if (guess(mid) == -1) {
            return guessNumber((mid + end) / 2, mid, end);
        }else if(guess(mid)==1) {
            return guessNumber((start+mid)/2,start, mid);
        }else {
            return mid;
        }
    }

    public static void main(String[] args) {
        GussNumberOhHigh gussNumberOhHigh = new GussNumberOhHigh();
        int n = gussNumberOhHigh.guessNumber(10);
        System.out.println(n);
    }

    int guess(int number){
        Queue queue = new LinkedList<>();
        queue.size();
        if (number>6) {
            return 1;
        } else if (number < 6) {
            return -1;
        }else {
            return 0;
        }

    }
}
