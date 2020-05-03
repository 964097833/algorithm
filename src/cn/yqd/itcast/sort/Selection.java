package cn.yqd.itcast.sort;

public class Selection {
    /**
     * 排序方法
     * @param a 待排序数组
     */
    public static void sort(Comparable[] a) {
        int minIndex;
        for (int i = 0; i < a.length; i++) {
            //假定本次遍历，最小值所在的索引是i
            minIndex = i;
            for (int j = i+1; j < a.length; j++) {
                //如果此处的值比索引中的值小，则更新最小值所在的索引
                if (greater(a[minIndex], a[j])) minIndex = j;
            }
            //交换i索引处和minIndex索引处的值
            swap(a,minIndex,i);
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
