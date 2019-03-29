/*
package com.leetcode;

import java.util.*;

*/
/**
 * Created by jiazhiwen on 2018/9/11.
 *//*

public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        char [] charArray = s.toCharArray();
        ArrayList<String> strings = new ArrayList<>();
        for (char str :charArray) {
            strings.add(String.valueOf(str));
            StringBuilder data = new StringBuilder();
            for (String d :strings) {
                data.append(d);
            }

            boolean flag =true;
            for (String ss:wordDict) {
                if (data.toString().equals(ss)) {
                    strings.clear();
                    flag = false;
                    break;
                }
                if (data.toString().length()<ss.length()) {
                    flag = false;
                }
            }
            if (flag) {
                return false;
            }
        }
        if (strings.size() != 0) {
            return false;
        }
        return true;

    }
}
*/
