package cn.yqd.zuo.basic;


/**
 * @Author yuqiaodi
 * @Date 2020/8/14 14:57
 * @Version 1.0
 */
public class Test {

    public static int getMax(int[] arr, int L, int R) {
        if (L == R) {
            return arr[L];
        }
        int mid = L + (R - L)/2;
        int maxLeft = getMax(arr, L, mid);
        int maxRight = getMax(arr, mid+1, R);
        return Math.max(maxLeft, maxRight);
    }

    public static void main(String[] args) {
        int[] arr = {4,3,1,2,5,6};
        System.out.println(getMax(arr,0,arr.length-1));
    }

}
