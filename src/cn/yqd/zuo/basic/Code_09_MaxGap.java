package cn.yqd.zuo.basic;

import cn.yqd.zuo.util.CheckDataUtil;

import java.util.Arrays;

/**
 * 给定一个数组，求如果排序之后，相邻两数的最大差值，要求时
 * 间复杂度O(N)，且要求不能用非基于比较的排序。
 * @Author yuqiaodi
 * @Date 2020/8/18 16:12
 * @Version 1.0
 */
public class Code_09_MaxGap {

    public static int maxGap(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }
        int len = arr.length;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < len; i++) {
            max = Math.max(max, arr[i]);
            min = Math.min(min, arr[i]);
        }
        if (max == min) {
            return 0;
        }
        boolean[] hasNum = new boolean[len + 1];
        int[] maxs = new int[len + 1];
        int[] mins = new int[len + 1];
        int bid = 0;
        for (int i = 0; i < len; i++) {
            // 获取桶的号数
            bid = bucket(arr[i],len,max,min);
            // 更新该桶中的最大、小值，标记该桶不为空
            maxs[bid] = hasNum[bid] ? (Math.max(arr[i], maxs[bid])) : arr[i];
            mins[bid] = hasNum[bid] ? (Math.min(arr[i], mins[bid])) : arr[i];
            hasNum[bid] = true;
        }
        int res = Integer.MIN_VALUE;
        int lastMax = maxs[0];
        for (int i = 1; i <= len; i++) {
            if (hasNum[i]) {
                // 只要是桶标记为不空的，则让该桶减去离它最近的前一个桶的最大值
                res = Math.max(res, mins[i] - lastMax);
                lastMax = maxs[i];
            }
        }
        return res;
    }

    /**
     * 求出该数在第几个桶中
     * @param num 数组中的某一个数
     * @param len 数组长度，+1为桶的个数
     * @param max 最大值
     * @param min 最小值
     * @return 返回桶编号
     */
    private static int bucket(long num, long len, long max, long min) {
        return (int) ((num - min) * len / (max - min));
    }

    /**
     * =========================================
     * 对数器
     */
    public static void main(String[] args) {
        int testTime = 500000;
        int size = 10;
        int value = 100;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = CheckDataUtil.generateRandomArray(size, value);
            int[] arr2 = CheckDataUtil.copyArray(arr1);
            int[] arr3 = CheckDataUtil.copyArray(arr1);
            int maxGap = maxGap(arr1);
            int right = rightMethod(arr2);
            if (maxGap != right) {
                CheckDataUtil.printArray(arr3);
                System.out.println("maxGap:" + maxGap);
                System.out.println("right:" + right);
                succeed = false;
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "error...");
        int[] arr = CheckDataUtil.generateRandomArray(size, value);
        CheckDataUtil.printArray(arr);
        System.out.println(maxGap(arr));
        System.out.println(rightMethod(arr));
    }

    /** 通过排序之后，遍历所有数，取其中相邻两数的最大值 */
    public static int rightMethod(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }
        int max = Integer.MIN_VALUE;
        Arrays.sort(arr);
        for (int i = 1; i < arr.length; i++) {
            max = Math.max(max, arr[i] - arr[i - 1]);
        }
        return max;
    }

}
