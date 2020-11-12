package com.example.suanfa;

/**
 * @author yangyangl
 * @date 2019-02-15 12:46
 *
 * https://github.com/doocs/coding-interview/blob/master/docs/coding-interview.md
 *
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
 * 解法
    跳上 n 级台阶，可以从 n-1 级跳 1 级上去，也可以从 n-2 级跳 2 级上去。所以

    f(n) = f(n-1) + f(n-2)
 */
public class frog {


    public static int JumpFloor(int target) {
        if (target < 3) {
            return target;
        }
        int a = 1, b = 2;
        for (int i = 3; i <= target; ++i) {
            b = a + b;
            a = b - a;
        }
        return b;
    }


    public static void main(String[] args) {

        int s = JumpFloor(3);
        System.out.println(s);

    }
}
