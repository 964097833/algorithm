package cn.yqd.itcast.sort;

/**
 * 插入排序
 */
public class Insertion {
    /**
     * 排序方法
     * @param a 待排序数组
     */
    public static void sort(Comparable[] a) {
        // 外层i代表已经有序的索引
        for (int i = 0; i < a.length-1; i++) {
            // 内层循环从i+1处开始向前比较
            for (int j = i+1; j > 0; j--) {
                if (greater(a[j-1],a[j])) swap(a,j-1,j);
                else break;
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
