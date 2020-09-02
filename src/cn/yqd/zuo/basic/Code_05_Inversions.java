package cn.yqd.zuo.basic;

import cn.yqd.zuo.util.CheckDataUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * ### 逆序对问题
 *
 * **在一个数组中，左边的数如果比右边的数大，则折两个数构成一个逆序对，请打印所有逆序对。**
 *
 * 例子：
 *
 * [1,3,4,2,5]
 *
 * 逆序对为：
 *
 * (3,2) (4,2)
 * @Author yuqiaodi
 * @Date 2020/8/27 11:44
 * @Version 1.0
 */
public class Code_05_Inversions {

    public static List<int[]> inversions(int[] arr) {

        if (arr == null || arr.length < 2) {
            return new ArrayList<>();
        }

        List<int[]> list = new ArrayList<>();

        sortProcess(list, arr, 0, arr.length - 1);

        return list;

    }

    private static void sortProcess(List<int[]> list, int[] arr, int L, int R) {
        if (L == R) {
            return;
        }
        int mid = L + ((R - L) >> 1);
        sortProcess(list, arr, L, mid);
        sortProcess(list, arr, mid + 1, R);
        merge(list, arr, L, mid, R);
    }

    private static void merge(List<int[]> list, int[] arr, int L, int mid, int R) {
        int i = 0;
        int p1 = L;
        int p2 = mid + 1;
        int[] help = new int[R - L + 1];
        for (int j = L; j <= mid; j++) {
            for (int k = mid + 1; k <= R && arr[j] > arr[k]; k++) {
                list.add(new int[] {arr[j], arr[k]});
            }
        }
        while (p1 <= mid && p2 <= R) {
            if (arr[p1] < arr[p2]) {
                help[i++] = arr[p1++];
            } else {
                help[i++] = arr[p2++];
            }
        }
        while (p1 <= mid) {
            help[i++] = arr[p1++];
        }
        while (p2 <= R) {
            help[i++] = arr[p2++];
        }
        for (int j = 0; j < help.length; j++) {
            arr[L + j] = help[j];
        }
    }

    /**
     * =========================================
     * 对数器
     * @return
     */
    public static void main(String[] args) {
        int testTime = 1000000;
        int size = 10;
        int value = 100;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = CheckDataUtil.generateRandomArray(size, value);
            int[] arr2 = CheckDataUtil.copyArray(arr1);
            int[] arr3 = CheckDataUtil.copyArray(arr1);
            List<int[]> myMethod = inversions(arr1);
            List<int[]> rightMethod = rightMethod(arr2);
            if (!isEqual(myMethod, rightMethod)) {
                succeed = false;
                CheckDataUtil.printArray(arr3);
                printArray(myMethod);
                printArray(rightMethod);
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "error...");
        int[] arr = CheckDataUtil.generateRandomArray(size, value);
        int[] copyArray = CheckDataUtil.copyArray(arr);
        List<int[]> list = rightMethod(arr);
        List<int[]> ints = inversions(copyArray);
        CheckDataUtil.printArray(arr);
        printArray(ints);
        printArray(list);
    }

    /**
     * 时间复杂度为n^2的找出逆序对的方法
     * @param arr
     * @return 返回逆序对数组
     */
    public static List<int[]> rightMethod(int[] arr) {
        List<int[]> lists = new ArrayList<>();

        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    lists.add(new int[] {arr[i], arr[j]});
                }
            }
        }

        return lists;
    }

    /** 打印逆序对 */
    private static void printArray(List<int[]> list) {
        for (int[] ints : list) {
            System.out.print("(" + ints[0] +"," + ints[1] + ")" + " ");
        }
        System.out.println();
    }

    /**
     * 比对两个集合中的逆序对是否对应
     * @param list1
     * @param list2
     * @return
     */
    public static boolean isEqual(List<int[]> list1, List<int[]> list2) {
        if ((list1 == null && list2 != null) || (list1 != null && list2 == null)) {
            return false;
        }
        if (list1 == null && list2 == null) {
            return true;
        }
        if (list1.size() != list2.size()) {
            return false;
        }
        for (int i = 0; i < list1.size(); i++) {
            for (int j = 0; j < list2.size(); j++) {
                if (j == list2.size() - 1) {
                    if (list1.get(i)[0] == list2.get(j)[0]) {
                        if (list1.get(i)[1] == list2.get(j)[1]) {
                            break;
                        } else {
                            return false;
                        }
                    } else {
                        return false;
                    }
                }
                if (list2.get(j)[0] == list1.get(i)[0]) {
                    if (list2.get(j)[1] == list1.get(i)[1]) {
                        break;
                    }
                }
            }
        }
        return true;
    }

}
