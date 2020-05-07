package cn.yqd.itcast.sort;

/**
 * 冒泡排序
 */
public class Bubble {
    /**
     * 排序方法
     * @param a 待排序数组
     */
    public static void sort(Comparable[] a) {
        // 外层循环控制循环的层数
        for (int i = a.length-1; i > 0; i--) {
            // 内层循环控制每层比较的次数，每次结束，在i位置的元素则是有序的
            for (int j = 0; j < i; j++) {
                // 前一个大于后一个则交换
                if (greater(a[j],a[j+1])) swap(a,j,j+1);
            }
        }
    }

    /**
     * 判断v是否大于w
     * @param v
     * @param w
     * @return
     */
    private static boolean greater(Comparable v,Comparable w) {
        return v.compareTo(w) > 0;
    }

    /**
     * 交换a数组中，索引i和索引j处的值
     * @param a
     * @param i
     * @param j
     */
    private static void swap(Comparable[] a,int i,int j){
        Comparable temp;
        temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
