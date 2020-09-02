package cn.yqd.zuo.basic;

import cn.yqd.zuo.util.CheckDataUtil;

import java.util.Arrays;

/**
 * @Author yuqiaodi
 * @Date 2020/8/17 14:14
 * @Version 1.0
 */
public class Code_08_HeapSort {

    public static void heapSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 1; i < arr.length; i++) {
            heapInsert(arr, i);
        }
        for (int i = arr.length - 1; i > 0; i--) {
            swap(arr, 0, i);
            heapify(arr, 0, i);
        }
    }

    private static void heapify(int[] arr, int index, int heapSize) {
        int left = index * 2 + 1;
        while (left < heapSize) {
            int largest = left + 1 < heapSize && arr[left] < arr[left + 1]
                    ? left + 1
                    : left;
            largest = arr[index] < arr[largest] ? largest : index;
            if (largest == index) {
                break;
            }
            swap(arr, index, largest);
            index = largest;
            left = index * 2 + 1;
        }
    }

    private static void heapInsert(int[] arr, int index) {
        while (arr[index] > arr[(index - 1 )/ 2]) {
            swap(arr, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
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
            heapSort(arr1);
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
        heapSort(arr);
        CheckDataUtil.printArray(arr);
    }

}
