package cn.yqd.itcast.sort;

public class Insertion {
    /**
     * 排序方法
     * @param a 待排序数组
     */
    public static void sort(Comparable[] a) {
        for (int i = 1; i < a.length; i++) {
            //当前元素为a[i],依次和i前面的元素比较，找到一个小于等于a[i]的元素
            for (int j = i-1; j >= 0; j--) {
                // 以排序数组中值大于a[i]时，进行交换
                if (greater(a[j],a[j+1])) swap(a,j,j+1);
                // 否则跳出循环
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
