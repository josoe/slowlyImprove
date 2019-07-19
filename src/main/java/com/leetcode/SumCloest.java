package com.leetcode;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by jiazhiwen on 2019/3/31.
 */
public class SumCloest {
    public int threeSumClosest(int[] nums, int target) {
        int[] result = Arrays.copyOf(nums, 3);
        for (int i = 3; i < nums.length; i++) {
            int sum = result[0] + result[1] + result[2];
            int sub = sum - target;
            HashMap<Integer, Integer> map = new HashMap<>();
            int a = Math.abs(sub + nums[i] - result[0]);//弥补效果
            map.put(a, 0);
            int b = Math.abs(sub + nums[i] - result[1]);
            map.put(b, 1);
            int c = Math.abs(sub + nums[i] - result[2]);
            map.put(c, 2);
            int value = Math.min(Math.min(a, b), c);
            if (value < Math.abs(sub)) {
                int index = map.get(value);
                result[index] = nums[i];
            }
        }
        return result[0] + result[1] + result[2];
    }
}
