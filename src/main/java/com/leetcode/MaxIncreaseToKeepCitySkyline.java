package com.leetcode;

/**
 * Created by jiazhiwen on 2019/3/30.
 */
public class MaxIncreaseToKeepCitySkyline {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        if (grid == null) {
            return 0;
        }
        int[] across = new int[grid[0].length];
        int[] vertical = new int[grid.length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (across[j] < grid[i][j]) {
                    across[j] = grid[i][j];
                }
                if (vertical[i] < grid[i][j]) {
                    vertical[i] = grid[i][j];
                }
            }
        }
        int sum = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] < across[j] && grid[i][j] < vertical[i]) {
                    int value = across[j] < vertical[i] ? across[j] - grid[i][j] : vertical[i] - grid[i][j];
                    sum += value;
                }
            }
        }
        return sum;
    }
}
