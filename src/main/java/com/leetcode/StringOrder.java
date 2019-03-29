package com.leetcode;

/**
 * Created by jiazhiwen on 2018/12/15.
 */
public class StringOrder {

    public Long value;

    public StringOrder(Long value) {
        this.value = value;
    }

    public Long getValue() {
        return value;
    }

    public void setValue(Long value) {
        this.value = value;
    }

    public boolean checkInclusion(String s1, String s2) {
        Integer m[] = new Integer [26];
        int begin = 0,endCount =0;
        for (char c:s1.toCharArray()) {
            m[c - 'a']++;
        }
        for (int i = 0;i<s2.toCharArray().length;i++) {
            if (m[s2.charAt(i) - 'a']-- > 0) {
            }
            if (i - begin == s2.toCharArray().length) {
                return true;
            }else {

            }
        }
        return false;
    }
    static{
        System.out.println("a");
    }


}
