package cn.yqd.zuo.util;

import java.util.Arrays;

/**
 * @description: 对数器：比对两组数据是否相等
 * @author: yuqiaodi
 * @date: 2020/8/31 9:27
 */
public class CheckDataUtil {

    /**
     * 随机样本产生器
     * @param size 数组大小
     * @param value 数据范围
     * @return 返回随机产生的数组
     */
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

    /**
     * 打印输出数组
     * @param arr 要打印的数组
     */
    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    /**
     * 拷贝数组
     * @param arr 待拷贝数组
     * @return 拷贝出来的数组
     */
    public static int[] copyArray(int[] arr) {
        if (arr == null || arr.length < 1) {
            return new int[0];
        }
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[i] = arr[i];
        }
        return res;
    }

    /**
     * 两个数组的比对方法
     * @param arr1
     * @param arr2
     * @return
     */
    public static boolean isEqual(int[] arr1, int[] arr2) {
        if ((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null)) {
            return false;
        }
        if (arr1 == null && arr2 == null) {
            return true;
        }
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    /**
     * 一个绝对正确的方法
     * @param arr 待排序数组
     */
    public static void rightMethod(int[] arr) {
        Arrays.sort(arr);
    }

}
