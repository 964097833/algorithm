package cn.yqd.zuo.basic;

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
        int size = 100;
        int value = 100;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = generateRandomArray(size, value);
            int[] arr2 = copyArray(arr1);
            int[] arr3 = copyArray(arr1);
            mergeSort(arr1);
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
        mergeSort(arr);
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
