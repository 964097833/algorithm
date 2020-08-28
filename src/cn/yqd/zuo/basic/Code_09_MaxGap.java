package cn.yqd.zuo.basic;

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
    /** 一个绝对正确的方法，可以直接调用一些库函数来进行测试 */
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

    /** 随机样本产生器 */
    public static int[] generateRandomArray(int size, int value) {
        //Math.random() -> double[0,1)
        //(int)((size + 1) * Math.random()) -> [0,size]整数
        // 生成长度随机[0,size]的数组
        int[] arr = new int[(int) ((size + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            // [-value, value]之间的随机数
            arr[i] = (int)((value+1) * Math.random()) - (int)((value+1) * Math.random());
        }
        return arr;
    }

    public static void main(String[] args) {
        int testTime = 500000;
        int size = 10;
        int value = 100;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = generateRandomArray(size, value);
            int[] arr2 = copyArray(arr1);
            int[] arr3 = copyArray(arr1);
            int maxGap = maxGap(arr1);
            int right = rightMethod(arr2);
            if (maxGap != right) {
                printArray(arr3);
                System.out.println("maxGap:" + maxGap);
                System.out.println("right:" + right);
                succeed = false;
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "error...");
        int[] arr = generateRandomArray(size, value);
        printArray(arr);
        System.out.println(maxGap(arr));
        System.out.println(rightMethod(arr));
    }

    private static void printArray(int[] arr3) {
        for (int i = 0; i < arr3.length; i++) {
            System.out.print(arr3[i] + " ");
        }
        System.out.println();
    }

    private static int[] copyArray(int[] arr1) {
        if (arr1 == null || arr1.length < 1) {
            return new int[0];
        }
        int[] res = new int[arr1.length];
        for (int i = 0; i < arr1.length; i++) {
            res[i] = arr1[i];
        }
        return res;
    }

}
