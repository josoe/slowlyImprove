package com.leetcode;

/**
 * Created by jiazhiwen on 2018/12/2.
 */
public class LongestPreix {
    public String longestCommonPrefix(String[] strs) {

        if(strs.length == 0){
            return "";
        }
        String prefix = strs[0];
        for (String str:strs) {
            if(str.length()==0){
                return "";
            }
            for (int i=0;i<prefix.length();i++) {
                if (prefix.charAt(i)==str.charAt(i)) {
                    if (str.length()==i+1) {
                        prefix = str.substring(0, i);
                    }
                    if(prefix.length()==i+1){
                        prefix = str.substring(0, i);
                    }
                    continue;
                }else {
                    prefix = str.substring(0, i);
                }
            }

        }
        return prefix;
    }

    public static void main(String[] args) {
        LongestPreix longestPreix = new LongestPreix();
        String[] a = {"a"};
        System.out.println(longestPreix.longestCommonPrefix(a));
    }
}
