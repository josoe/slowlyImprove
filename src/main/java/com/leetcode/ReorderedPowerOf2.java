package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by jiazhiwen on 2018/10/7.
 */
public class ReorderedPowerOf2 {


        public static final int[][][] table = { { { 0, 1, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 1, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 1, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 1, 0 } },

                { { 0, 1, 0, 0, 0, 0, 1, 0, 0, 0 }, { 0, 0, 1, 1, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 1, 0, 1, 0, 0, 0 } },

                { { 0, 1, 1, 0, 0, 0, 0, 0, 1, 0 }, { 0, 0, 1, 0, 0, 1, 1, 0, 0, 0 }, { 0, 1, 1, 0, 0, 1, 0, 0, 0, 0 } },

                { { 1, 1, 1, 0, 1, 0, 0, 0, 0, 0 }, { 1, 0, 1, 0, 1, 0, 0, 0, 1, 0 }, { 1, 0, 0, 0, 1, 0, 1, 0, 0, 1 },
                        { 0, 1, 1, 0, 0, 0, 0, 0, 1, 1 } },

                { { 0, 1, 0, 1, 1, 0, 1, 0, 1, 0 }, { 0, 0, 1, 1, 0, 0, 1, 1, 1, 0 }, { 0, 0, 0, 1, 0, 2, 2, 0, 0, 0 } },

                { { 1, 2, 1, 1, 0, 0, 0, 1, 0, 0 }, { 0, 1, 2, 0, 2, 0, 1, 0, 0, 0 }, { 0, 0, 2, 0, 1, 1, 0, 0, 2, 0 } },

                { { 1, 1, 0, 0, 1, 1, 1, 1, 1, 0 }, { 1, 1, 2, 0, 0, 1, 0, 1, 0, 1 }, { 1, 1, 0, 1, 3, 0, 0, 0, 0, 1 },
                        { 1, 0, 0, 1, 0, 0, 1, 0, 4, 0 } },

                { { 0, 2, 1, 0, 0, 0, 2, 3, 0, 0 }, { 0, 0, 1, 3, 2, 2, 0, 0, 0, 0 }, { 1, 1, 0, 0, 1, 0, 2, 1, 2, 0 } },

                { { 0, 2, 2, 1, 1, 0, 0, 2, 1, 0 }, { 0, 0, 1, 1, 2, 2, 2, 0, 1, 0 }, { 1, 1, 1, 1, 0, 1, 1, 1, 1, 1 } },

                { { 1, 2, 1, 1, 2, 0, 0, 2, 1, 0 } } };

        public static boolean reorderedPowerOf2(int n) {
            int[] counts = new int[10];
            int digit = 0;
            while (n > 0) {
                ++counts[n % 10];
                ++digit;
                n /= 10;
            }
            int[][] array = table[digit - 1];
            int length = array.length;
            for (int i = 0; i < length; ++i)
                if (Arrays.equals(array[i], counts))
                    return true;
            return false;
        }

    public static void main(String[] args) {
        reorderedPowerOf2(32);
    }
}
