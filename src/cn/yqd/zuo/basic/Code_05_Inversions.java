package cn.yqd.zuo.basic;

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
    // 一个绝对正确的方法，可以直接调用一些库函数来进行测试
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


    public static void main(String[] args) {
        int testTime = 1000000;
        int size = 10;
        int value = 100;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = generateRandomArray(size, value);
            int[] arr2 = copyArray(arr1);
            int[] arr3 = copyArray(arr1);
            List<int[]> myMethod = inversions(arr1);
            List<int[]> rightMethod = rightMethod(arr2);
            if (!isEqual(myMethod, rightMethod)) {
                succeed = false;
                printArray(arr3);
                printArray(myMethod);
                printArray(rightMethod);
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "error...");
        int[] arr = generateRandomArray(size, value);
        int[] copyArray = copyArray(arr);
        List<int[]> list = rightMethod(arr);
        List<int[]> ints = inversions(copyArray);
        printArray(arr);
        printArray(ints);
        printArray(list);
    }

    private static void printArray(int[] arr3) {
        for (int i = 0; i < arr3.length; i++) {
            System.out.print(arr3[i] + " ");
        }
        System.out.println();
    }

    private static void printArray(List<int[]> list) {
        for (int[] ints : list) {
            System.out.print("(" + ints[0] +"," + ints[1] + ")" + " ");
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

    // 实现两个数组比对的方法
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
