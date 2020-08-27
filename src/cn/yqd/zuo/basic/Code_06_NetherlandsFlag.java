package cn.yqd.zuo.basic;

/**
 * 荷兰国旗问题：
 * 给定一个数组arr，和一个数num，请把小于num的数放在数组的
 * 左边，等于num的数放在数组的中间，大于num的数放在数组的
 * 右边。
 * 要求额外空间复杂度O(1)，时间复杂度O(N)
 * @Author yuqiaodi
 * @Date 2020/8/15 16:45
 * @Version 1.0
 */
public class Code_06_NetherlandsFlag {

    public static int[] netherlandsFlag(int[] arr, int L, int R, int p) {
        if (L >= R) {
            return new int[0];
        }
        int less = L - 1;
        int more = R + 1;
        while (L < more) {
            if (arr[L] < p) {
                swap(arr, ++less, L++);
            } else if (arr[L] > p) {
                swap(arr,--more,L);
            } else {
              L++;
            }
        }
        return new int[]{less+1,more-1};
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        int[] arr = {7,8,9,5,1,2,3};
        int[] flag = netherlandsFlag(arr, 0, arr.length - 1, 5);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
