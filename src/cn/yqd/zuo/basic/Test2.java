package cn.yqd.zuo.basic;


/**
 * @Author yuqiaodi
 * @Date 2020/8/16 14:55
 * @Version 1.0
 */
public class Test2 {

    private static void rotate(int[][] arr) {
        int aLeft = 0;
        int bLeft = 0;
        int cRight = arr[0].length - 1;
        int dRight = arr.length - 1;
    }

    public static void main(String[] args) {
        int[][] arr = {
                {1,2,3,4},
                {12,13,14,5},
                {11,16,15,6},
                {10,9,8,7}
        };
        rotate(arr);
        System.out.println();
    }


}
