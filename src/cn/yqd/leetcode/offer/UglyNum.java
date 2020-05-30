package cn.yqd.leetcode.offer;

import java.util.ArrayList;
import java.util.List;

/**
 * 面试题49. 丑数
 * 我们把只包含因子 2、3 和 5 的数称作丑数（Ugly Number）。求按从小到大的顺序的第 n 个丑数。
 *
 * 示例:
 * 输入: n = 10
 * 输出: 12
 * 解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。
 *
 * 说明:
 * 1 是丑数。
 * n 不超过1690。
 */
public class UglyNum {

    public static void main(String[] args) {
        int number = nthUglyNumber(10);
        System.out.println(number);
    }

    public static int nthUglyNumber(int n) {
        if (n==0) return 0;
        if (n==1) return 1;
        List<Integer> resList = new ArrayList<>();
        resList.add(1);
        int a,b,c,i1=0,i2=0,i3=0;
        a = resList.get(i1) * 2;

        b = resList.get(i2) * 3;

        c = resList.get(i3) * 5;

        while (resList.size() <= n+1) {
            if (a <= b) {
                if (a <= c) {
                    if (!resList.contains(a)) {
                        resList.add(a);
                    }
                    a = resList.get(++i1) * 2;
                    continue;
                }
            }
            if (c <= b) {
                if (c <= a) {
                    if (!resList.contains(c)) {
                        resList.add(c);
                    }
                    c = resList.get(++i3) * 5;
                    continue;
                }
            }
            if (b <= a) {
                if (b <= c) {
                    if (!resList.contains(b)) {
                        resList.add(b);
                    }
                    b = resList.get(++i2) * 3;
                    continue;
                }
            }
        }
        return resList.get(n-1);
    }
}
