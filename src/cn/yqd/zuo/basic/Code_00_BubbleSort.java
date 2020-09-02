package cn.yqd.zuo.basic;

import cn.yqd.zuo.util.CheckDataUtil;

/**
 * @Author yuqiaodi
 * @Date 2020/8/14 9:54
 * @Version 1.0
 */
public class Code_00_BubbleSort {

    public static void bubbleSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int end = arr.length - 1; end > 0; end--) {
            for (int j = 0; j < end; j++) {
                if (arr[j] > arr[j+1]) {
                    swap(arr, j, j+1);
                }
            }
        }
    }

    public static void swap(int[] arr, int i, int j) {
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
            bubbleSort(arr1);
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
        bubbleSort(arr);
        CheckDataUtil.printArray(arr);
    }

}
