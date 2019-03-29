package com.leetcode;

/**
 * Created by jiazhiwen on 2018/10/6.
 */
public class SIngleNumberIII {
        public int[] singleNumber(int[] nums) {
            int sum = 0;
            for(int i=0;i<nums.length;i++){
                sum = sum ^ nums[i];
            }
            int flag = sum&(~(sum-1));

            int a = 0;
            int b = 0;
            for(int i = 0;i<nums.length;i++){
                if((nums[i]&flag) ==0){
                    a = a ^ nums[i];
                }
                if((nums[i]&flag) !=0){
                    b = b ^ nums[i];
                }
            }
            int [] result = {a,b};
            return result;
        }
    public static void main(String[] args) {
        StringOrder[] stringOrders = new StringOrder[10];
    }
}
