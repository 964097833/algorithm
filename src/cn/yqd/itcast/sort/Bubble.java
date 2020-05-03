package cn.yqd.itcast.sort;

public class Bubble {
    /**
     * 排序方法
     * @param a 待排序数组
     */
    public static void sort(Comparable[] a) {
        for (int i = a.length-1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (greater(a[j],a[j+1])) {
                    swap(a,j,j+1);
                }
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
