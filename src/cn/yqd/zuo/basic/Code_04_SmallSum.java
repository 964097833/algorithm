package cn.yqd.zuo.basic;


/**
 * 小和问题
 * 在一个数组中，每一个数左边比当前数小的数累加起来，叫做这个数组的小和。求一个数组
 * 的小和。
 * 例子：
 * [1,3,4,2,5]
 * 1左边比1小的数，没有；
 * 3左边比3小的数，1；
 * 4左边比4小的数，1、3；
 * 2左边比2小的数，1；
 * 5左边比5小的数，1、3、4、2；
 * 所以小和为1+1+3+1+1+3+4+2=16
 * @Author yuqiaodi
 * @Date 2020/8/15 15:43
 * @Version 1.0
 */
public class Code_04_SmallSum {

    public static int smallSum(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }
        return mergeSort(arr, 0, arr.length - 1);
    }

    private static int mergeSort(int[] arr, int L, int R) {

        if (L == R) {
            return 0;
        }
        int mid = L + ((R - L) >> 1);
        return mergeSort(arr, L, mid)
                +mergeSort(arr, mid + 1, R)
                +merge(arr, L, mid, R);
    }

    private static int merge(int[] arr, int L, int mid, int R) {

        int p1 = L;
        int p2 = mid + 1;
        int[] help = new int[R - L +1];
        int i = 0;
        int res = 0;

        while (p1 <= mid && p2 <= R) {
            res += arr[p1] < arr[p2] ? arr[p1] * (R - p2 + 1) : 0;
            help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
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
        return res;

    }

    /**
     * =========================================
     * 对数器
     */
    // 一个绝对正确的方法，可以直接调用一些库函数来进行测试
    public static int rightMethod(int[] arr) {
        int res = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                res += arr[i] < arr[j] ? arr[i] : 0;
            }
        }
        return res;
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
        int testTime = 500000;
        int size = 100;
        int value = 1000;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = generateRandomArray(size, value);
            int[] arr2 = copyArray(arr1);
            int[] arr3 = copyArray(arr1);
            int smallSum = smallSum(arr1);
            int rightMethod = rightMethod(arr2);
            if (smallSum != rightMethod) {
                succeed = false;
                printArray(arr3);
                System.out.println(smallSum);
                System.out.println(rightMethod);
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "error...");
        int[] arr = generateRandomArray(size, value);
        int[] copyArray = copyArray(arr);
        printArray(arr);
        System.out.println(smallSum(arr));
        System.out.println(rightMethod(copyArray));
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
