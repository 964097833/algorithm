package cn.yqd.zuo.basic;

import java.util.Arrays;

/**
 * @Author yuqiaodi
 * @Date 2020/8/15 17:15
 * @Version 1.0
 */
public class Code_07_QuickSort {

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
    // 一个绝对正确的方法，可以直接调用一些库函数来进行测试
    public static void rightMethod(int[] arr) {
        Arrays.sort(arr);
    }

    // 随机样本产生器
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

    // 实现两个数组比对的方法
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

    public static void main(String[] args) {
        int testTime = 500000;
        int size = 10;
        int value = 100;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = generateRandomArray(size, value);
            int[] arr2 = copyArray(arr1);
            int[] arr3 = copyArray(arr1);
            quickSort(arr1,0,arr1.length-1);
            rightMethod(arr2);
            if (!isEqual(arr1,arr2)) {
                succeed = false;
                printArray(arr3);
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "error...");
        int[] arr = generateRandomArray(size, value);
        printArray(arr);
        quickSort(arr,0,arr.length-1);
        printArray(arr);
//        int[] arr = {1,2,0,4,3,1};
//        mergeSort(arr);
//        printArray(arr);
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