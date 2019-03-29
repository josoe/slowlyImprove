package com.leetcode;

/**
 * Created by jiazhiwen on 2018/12/2.
 */
public class StringSort {
       /* public boolean checkInclusion(String s1, String s2) {
            ArrayDeque<String> arrayDeque = new ArrayDeque<>();
            for (char a : s1.toCharArray()) {
                arrayDeque.add(String.valueOf(a));
            }
            StringBuilder strBuilder = new StringBuilder();
            return clusion(arrayDeque, s1.length(),strBuilder,s2);
        }

        private boolean clusion(ArrayDeque<String> strings,int num,StringBuilder strBuilder,String s2) {
            if (num == 1) {
                String value = strings.poll();
                strBuilder.append(value);
                if (s2.contains(strBuilder.toString())) {
                    return true;
                }
                strBuilder.deleteCharAt(strBuilder.length() - 1);
                strings.add(value);
                return false;
            }
            for (int i = 0; i < num; i++) {
                String value =  strings.poll();
                strBuilder.append(value);
                if (!s2.contains(strBuilder.toString())) {
                    return false;
                }
                if ( clusion(strings, num - 1, strBuilder, s2)) {
                    return true;
                }
                strBuilder.deleteCharAt(strBuilder.length()-1);
                strings.addLast(value);
            }
            return false;
        }*/


    public boolean checkInclusion(String s1, String s2) {
        int n1 = s1.length(), n2 = s2.length(), cnt = n1, left = 0;
        int[] m = new int[3];
        for (char c : s1.toCharArray())
            ++m[c-'a'];
        for (int right = 0; right < n2; ++right) {
            if (m[s2.charAt(right)-'a']-- > 0) --cnt;
            while (cnt == 0) {
                if (right - left + 1 == n1) return true;
                if (++m[s2.charAt(left++)-'a'] > 0) ++cnt;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        StringSort stringSort = new StringSort();
        stringSort.checkInclusion("abc", "aabbccab");
    }

}
