package com.leetcode;

import java.util.ArrayDeque;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * Created by jiazhiwen on 2018/12/2.
 */
public class BigStringLength {
    public int lengthOfLongestSubstring(String s) {
        int length = 0;
        ArrayDeque<String> stringArrayDeque = new ArrayDeque<>(s.length());
        for (char a:s.toCharArray()) {
            if (stringArrayDeque.contains( String.valueOf(a))) {
                if (length<stringArrayDeque.size()) {
                    length = stringArrayDeque.size();
                }
                while (!stringArrayDeque.isEmpty()) {
                    String value = stringArrayDeque.poll();
                    if (value.equals(String.valueOf(a))) {
                        stringArrayDeque.add(String.valueOf(a));
                        break;
                    }
                }
            }else {
                stringArrayDeque.add(String.valueOf(a));
            }
        }
        if (length<stringArrayDeque.size()) {
            length = stringArrayDeque.size();
        }
        return length;
    }
}
