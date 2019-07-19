package com.leetcode;

/**
 * Created by jiazhiwen on 2019/4/5.
 */
public class ComplementOfBase10Integer {
    public int bitwiseComplement(int N) {
        if (N == 0) {
            return 1;
        }
        int sum=0;
        int i = 0;
        while (N!=0) {
            int index = N & 1;
            int a = 0;
            if (index == 1) {
                a = 0;
            } else {
                a = 1;
            }
            sum = sum +a*(int) Math.pow(2, i);
            N = N >> 1;
        }
        return sum;
    }

    public static void main(String[] args) {
        for(int i = 0;i< 100;i++){
            try {
                Thread.sleep(10000);
                System.out.println("a");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
        ComplementOfBase10Integer complementOfBase10Integer = new ComplementOfBase10Integer();
        int a= complementOfBase10Integer.bitwiseComplement(5);
        System.out.println(a);
    }
}
