package com.leetcode;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by jiazhiwen on 2018/10/25.
 */
public class ExclusiveTimeofFunctions {
    public void kaiche(){

    }
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] time=new int[n];
        //stack存:所有的start

        //int[0]存:functionId,int[1]存:timePoint,int[2]存:被别人占用的时间
        Stack<int[]> stack=new Stack<int[]>();
        for(String s:logs){
            String[] it=s.split(":");
            int id=Integer.parseInt(it[0]);
            String startOrEnd=it[1];
            int timePoint=Integer.parseInt(it[2]);
            if(startOrEnd.equals("start")){
                stack.push(new int[]{id,timePoint,0});
            }
            else{//startOrEnd.equals("end")
                int[] the=stack.pop();
                int usedTime=timePoint+1-the[1]-the[2];
                time[id]+=usedTime;
                //对于当前还在栈中的每个function
                //都被当前function占用了时间
                ArrayList<int[]> list=new ArrayList<int[]>();
                while(!stack.isEmpty()){
                    int[] tmp=stack.pop();
                    tmp[2]+=usedTime;
                    list.add(tmp);
                }
                for(int i=list.size()-1;i>=0;i--){
                    stack.push(list.get(i));
                }
            }
        }
        return time;
    }
    public static void main(String[] args) {
        ExclusiveTimeofFunctions exclusiveTimeofFunctions = new ExclusiveTimeofFunctions();
        List<String> list = new ArrayList();
        list.add("0:start:0");
        list.add("0:start:2");
        list.add("0:end:5");
        list.add("0:start:6");
        list.add("0:end:6");
        list.add("0:end:7");
 /*       list.add("0:start:0");
        list.add("1:start:2");
        list.add("1:end:5");
        list.add("0:end:6");*/
      /*  list.add("0:start:0");
        list.add("1:start:4");
        list.add("2:start:8");
        list.add("3:start:12");
        list.add("4:start:17");
        list.add("5:start:18");
        list.add("6:start:20");
        list.add("7:start:21");
        list.add("8:start:23");
        list.add("9:start:24");
        list.add("10:start:28");
        list.add("11:start:32");
        list.add("11:end:687");
        list.add("10:end:693");
        list.add("9:end:697");
        list.add("8:end:701");
        list.add("7:end:705");
        list.add("6:end:709");
        list.add("5:end:710");
        list.add("4:end:711");
        list.add("3:end:714");
        list.add("2:end:718");
        list.add("1:end:747");
        list.add("0:end:749");*/

        int[] a = exclusiveTimeofFunctions.exclusiveTime(12, list);
        for (int i=0;i<a.length;i++) {
            System.out.println(a[i]);
        }
    }
  /*  11
            ["0:start:0","1:start:4","2:start:8","3:start:12","4:start:17","5:start:18",
            "6:start:20","7:start:21","8:start:23","9:start:24","10:start:28","10:end:693","9:end:697",
            "8:end:701","7:end:705","6:end:709","5:end:710","4:end:711","3:end:714","2:end:718","1:end:747","0:end:749"]*/

}
