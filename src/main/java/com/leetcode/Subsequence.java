package com.leetcode;

import java.util.*;

/**
 * Created by jiazhiwen on 2018/10/23.
 */
public class Subsequence {
    public static boolean isSubsequence(String s, String t) {

            if(s.equals(t)){
                return true;
            }
            char [] array = t.toCharArray();
            int i =0;
            for (char value:array) {
                if (i +1 == s.length()) {
                    return true;
                }
                if (value ==s.charAt(i)) {
                    i++;
                }
                if (i +1 == s.length()) {
                    return true;
                }
            }
            return false;
        }

    public static void main(String[] args) {
        System.out.println(isSubsequence("ahbgdc", "abc"));
    }
}
