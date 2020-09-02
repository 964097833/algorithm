package cn.yqd.zuo.basic;

import cn.yqd.zuo.util.CheckDataUtil;

import java.util.Arrays;

/**
 * @Author yuqiaodi
 * @Date 2020/8/15 17:15
 * @Version 1.0
 */
public class Code_07_QuickSort {

    public static void quickSort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    public static void quickSort(int[] arr, int L, int R) {
        if (L < R) {
            swap(arr, L + (int)((R - L + 1) * Math.random()), R);
            int[] p = partition(arr, L, R);
            quickSort(arr, L, p[0] - 1);
            quickSort(arr, p[1] + 1, R);
        }
    }

    private static int[] partition(int[] arr, int L, int R) {
        int less = L - 1;
        int more = R;
        while (L < more) {
            if (arr[L] < arr[R]) {
                swap(arr, ++less, L++);
            } else if (arr[L] > arr[R]) {
                swap(arr, L, --more);
            } else {
                L++;
            }
        }
        swap(arr, more, R);
        return new int[] {less + 1, more};
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
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
            quickSort(arr1);
            CheckDataUtil.rightMethod(arr2);
            if (!CheckDataUtil.isEqual(arr1,arr2)) {
                succeed = false;
                CheckDataUtil.printArray(arr3);
                CheckDataUtil.printArray(arr1);
                CheckDataUtil.printArray(arr2);
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "error...");
        int[] arr = CheckDataUtil.generateRandomArray(size, value);
        CheckDataUtil.printArray(arr);
        quickSort(arr);
        CheckDataUtil.printArray(arr);
    }

}