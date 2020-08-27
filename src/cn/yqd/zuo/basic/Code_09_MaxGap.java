package cn.yqd.zuo.basic;

/**
 * 给定一个数组，求如果排序之后，相邻两数的最大差值，要求时
 * 间复杂度O(N)，且要求不能用非基于比较的排序。
 * @Author yuqiaodi
 * @Date 2020/8/18 16:12
 * @Version 1.0
 */
public class Code_09_MaxGap {

    public static int maxGap(int[] arr) {
        int len = arr.length;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < len; i++) {
            max = Math.max(max, arr[i]);
            min = Math.min(min, arr[i]);
        }
        boolean[] hasNum = new boolean[len + 1];
        int[] maxs = new int[len + 1];
        int[] mins = new int[len + 1];
        int bid = 0;
        for (int i = 0; i < len; i++) {
            bid = bucket(arr[i],len,max,min);
            maxs[bid] = hasNum[bid] ? (Math.max(arr[i], maxs[bid])) : arr[i];
            mins[bid] = hasNum[bid] ? (Math.min(arr[i], mins[bid])) : arr[i];
            hasNum[bid] = true;
        }
        int res = Integer.MIN_VALUE;
        int lastMax = maxs[0];
        for (int i = 1; i < len + 1; i++) {
            if (hasNum[i]) {
                res = Math.max(res, mins[i] - lastMax);
                lastMax = maxs[i];
            }
        }
        return res;
    }

    private static int bucket(int num, int len, int max, int min) {
        return (num - min) * len / (max - min);
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,6,7,8};
        System.out.println(maxGap(arr));
    }

}
