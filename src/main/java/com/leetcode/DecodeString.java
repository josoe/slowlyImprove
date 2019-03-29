package com.leetcode;

import java.util.*;
import java.util.concurrent.LinkedTransferQueue;

/**
 * Created by jiazhiwen on 2018/11/16.
 */
public class DecodeString {

    public static void main(String[] args) {
        DecodeString decodeString = new DecodeString();
        System.out.println(decodeString.decodeString("3[a]2[bc]"));
    }


    public String decodeString(String s) {
        char [] charArray = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        List<String> listCurrent = new ArrayList<>();
        Map<String,List<String>> map = new HashMap<>();
        Stack<String> stack = new Stack<>();
        String currentKey = "";
        for(int i=0;i<charArray.length;i++){

            if(charArray[i]=='['){
                stack.push(i+"");
                List<String> list = new ArrayList<>();
                map.put(i + "", list);
                currentKey = "" + i;
                continue;
            }
            if(charArray[i]==']'){
                String begin = stack.pop();
                int num = Integer.valueOf(begin)-1;
                int value =getNum(charArray, num);
                List<String> list =  map.get("" + currentKey);
                for(int j=0;j<value;j++){
                    listCurrent.addAll(list);
                }
                if(stack.isEmpty()){
                    for(String str:listCurrent){
                        sb.append(str);
                    }
                    currentKey = "";
                    listCurrent = new ArrayList<>();
                }else {
                    String top = stack.peek();
                    List<String> upList =  map.get("" + top);
                    upList.addAll(listCurrent);
                    map.put("" + top, upList);
                    currentKey = top;
                    listCurrent = new ArrayList<>();
                }
                continue;
            }

            if(charArray[i]-'0'>=0&&charArray[i]-'0'<=9){
                continue;
            }
            List<String> list =  map.get(currentKey);
            if (list == null) {
                sb.append(String.valueOf(charArray[i]));
                continue;
            }
            list.add(String.valueOf(charArray[i]));

        }

        return sb.toString();
    }

    private static int getNum(char []charArray,int num){
        if (num == 0) {
            return charArray[num]-'0';
        }
        Stack<String> stack = new Stack();
        stack.push(String.valueOf(charArray[num]));

        while (charArray[num-1]-'0'>=0&&charArray[num-1]-'0'<=9) {
            stack.push(String.valueOf(charArray[num-1]));
            num = num -1;
            if (num==0) {
                break;
            }
        }
        StringBuffer str = new StringBuffer();
        while (!stack.isEmpty()) {
            str.append(stack.pop());
        }
        return Integer.valueOf(str.toString());
    }
}
