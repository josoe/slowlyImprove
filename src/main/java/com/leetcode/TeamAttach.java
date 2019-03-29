package com.leetcode;

/**
 * Created by jiazhiwen on 2019/3/26.
 */
public class TeamAttach {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int i = 0;
        int start = timeSeries[0];
        int sum = 0;
        while (i + 1 < timeSeries.length) {
            if (start + duration < timeSeries[i + 1]) {
                if (timeSeries[i] + duration < timeSeries[i + 1]) {
                    sum += timeSeries[i] - start + duration;
                } else {
                    sum += timeSeries[i + 1] - start;
                }
                start = timeSeries[i + 1];
            }
            i++;
        }
        return sum + timeSeries[i] - start + duration;
    }

    public static void main(String[] args) {
        TeamAttach teamAttach = new TeamAttach();
        int[] a = {1, 2};
        teamAttach.findPoisonedDuration(a, 2);
    }
}
