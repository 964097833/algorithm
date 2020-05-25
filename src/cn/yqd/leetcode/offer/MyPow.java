package cn.yqd.leetcode.offer;

/**
 * 实现函数double Power(double base, int exponent)，求base的exponent次方。不得使用库函数，同时不需要考虑大数问题。
 *示例 1:
 *
 * 输入: 2.00000, 10
 * 输出: 1024.00000
 * 示例 2:
 *
 * 输入: 2.10000, 3
 * 输出: 9.26100
 * 示例 3:
 *
 * 输入: 2.00000, -2
 * 输出: 0.25000
 * 解释: 2-2 = 1/22 = 1/4 = 0.25
 *
 * 说明:
 *
 * -100.0 < x < 100.0
 * n 是 32 位有符号整数，其数值范围是 [−2^31, 2^31 − 1] 。
 */
public class MyPow {

    public static double myPow(double x, int n) {
        if (x == 1.0) return x;
        if (x == -1.0) {
            if (n%2==1) return x;
            return -x;
        }
        if (n < 0) {
            x = 1/x;
            if (n==-2147483648) return 0.0;
            n = -n;
        }
        double res=1.0;
        for (int i=0; i < n; i++) {
            res = res*x;
        }
        return res;
    }

    public static void main(String[] args) {
        double v = myPow(2.0, -2147483647);
        System.out.println(v);
    }

}
