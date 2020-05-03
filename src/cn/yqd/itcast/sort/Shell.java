package cn.yqd.itcast.sort;

public class Shell {
    /**
     * 排序方法
     * @param a 待排序数组
     */
    public static void sort(Comparable[] a) {
        int h=1;
        while (h < a.length/2) {
            h = 2*h+1;
        }
        while (h >= 1) {
            for (int i = h; i < a.length; i++) {
                for (int j = i; j >= h; j-=h) {
                    if (greater(a[j-h],a[j])) swap(a,j-h,j);
                    else break;
                }
            }
            h = h/2;
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
