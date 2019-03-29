package com.leetcode;

import java.util.Arrays;

/**
 * Created by jiazhiwen on 2019/3/29.
 */
public class RelativeRanks {
    public String[] findRelativeRanks(int[] nums) {
        int[] numsCopy = Arrays.copyOf(nums, nums.length);
        Arrays.sort(numsCopy);
        String[] result = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int index = Arrays.binarySearch(numsCopy, nums[i]);
            int length = nums.length;
            if (index == length-1) {
                result[i] = "Gold Medal";
            } else if (index ==length- 2) {
                result[i] = "Silver Medal";
            } else if (index == length-3) {
                result[i] = "Bronze Medal";
            } else {
                result[i] = length-index + "";
            }
        }
        return result;

    }
}
