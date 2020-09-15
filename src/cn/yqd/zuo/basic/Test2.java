package cn.yqd.zuo.basic;


/**
 * [应用] 数组循环右移 将一个长度为n的数组A的元素循环右移k位, 比如 数组 1, 2, 3, 4, 5 循环右移3位之后变成 3, 4, 5, 1, 2
 * @Author yuqiaodi
 * @Date 2020/8/16 14:55
 * @Version 1.0
 */
public class Test2 {

    public static int getHouses (int t, int[] xa) {
        if (xa.length == 0) {
            return 1;
        }
        if (xa.length == 2) {
            return 2;
        }
        int[] nums = new int[xa.length / 2 - 1];
        int n = 0;
        int left = 0;
        int right = xa[0] + xa[1] / 2;;
        for (int i = 2; i < xa.length; i = i + 2) {
            left = xa[i] - xa[i + 1] / 2;
            nums[n++] = left - right;
            right = xa[i] + xa[i + 1] / 2;
        }
        int res = 2;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > t) {
                res = res + 2;
            } else if (nums[i] == t) {
                res++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
//        method(arr,3);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

}
