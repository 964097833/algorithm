package cn.yqd.zuo.basic;

import cn.yqd.zuo.util.CheckDataUtil;

import java.util.Arrays;

/**
 * @Author yuqiaodi
 * @Date 2020/8/14 15:37
 * @Version 1.0
 */
public class Code_03_MergeSort {

    public static void mergeSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        sortProcess(arr, 0, arr.length - 1);
    }

    private static void sortProcess(int[] arr, int L, int R) {
        if (L == R) {
            return;
        }
        int mid = L + ((R-L) >> 1); // L和R的中间位置：(L+R)/2,注：位运算比常数运算更快，L+(R-L)/2可以防止溢出
        sortProcess(arr, L, mid);
        sortProcess(arr, mid+1, R);
        merge(arr, L, mid, R);
    }

    private static void merge(int[] arr, int L, int mid, int R) {
        int[] help = new int[R - L + 1];
        int i = 0;
        int p1 = L;
        int p2 = mid + 1;
        while (p1 <= mid && p2 <= R) {
            // 此条件判断使归并排序不具有稳定性
            //help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
            // 当两数相等时，优先把左边的数放进help数组才能使归并排序具备稳定性
            help[i++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];
        }
        while (p1 <= mid) {
            help[i++] = arr[p1++];
        }
        while (p2 <= R) {
            help[i++] = arr[p2++];
        }
        for (int k = 0; k < help.length; k++) {
            arr[L + k] = help[k];
        }
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
            mergeSort(arr1);
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
        mergeSort(arr);
        CheckDataUtil.printArray(arr);
    }

}
