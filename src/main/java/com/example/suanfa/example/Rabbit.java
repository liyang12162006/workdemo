package com.example.suanfa.example;

/**
 * @author liyangyang
 * @date 2020/12/25 16:33
 * @since 2.4.0.0
 *
 * 有一对兔子，从出生后第3个月起每个月都生一对兔子，小兔子长到第三个月后
 * 每个月又生一对兔子，假如兔子都不死，问每个月的兔子对数为多少?
 * 程序分析:兔子的规律 为数列1,1,2,3,5,8,13,21...
 *  1 2 3 4 5 6 7
 *  1 1 1 1 1 1 1
 *        1 1 1 1
 *        1 1 1 1
 *          1 1 1
 *          1 1 1
 *            1 1
 *            1 1
 *              1
 *              1
 *      1 1 1 1 1
 *      1 1 1 1 1
 *          1 1 1
 *          1 1 1
 *            1 1
 *            1 1
 *            1 1
 *            1 1
 *
 *  1 1 3 5
 */
public class Rabbit {

    public static void main(String[] args) {
        int n = 9;
        System.out.println("--" + rabbiteCount(n));

    }

    public static int rabbiteCount(int n) {
        if (n == 1 || n == 2) {
            return n;
        } else {
            return rabbiteCount(n - 1) + rabbiteCount(n - 2);
        }

    }
}
