package cn.yqd.itcast.sort;

public class Merge {
    /**
     * 完成归并操作需要的辅助数组
     */
    private static Comparable[] assist;

    /**
     * 对数组内的元素进行排序
     * @param a
     */
    public static void sort(Comparable[] a) {
        // 初始化辅助数组
        assist = new Comparable[a.length];
        int lo = 0;
        int hi = a.length - 1;
        sort(a,lo,hi);
    }

    /**
     * 对数组a中从索引lo到索引hi之间的元素进排序
     * @param a
     * @param lo
     * @param hi
     */
    private static void sort(Comparable[] a, int lo, int hi) {
        // 分到只剩一个的时候就不再分
        if (lo >= hi) return;
        // 获取中间索引
        int mid = lo + (hi - lo) / 2;
        // 细分
        sort(a,lo,mid);
        sort(a,mid+1,hi);
        // 合并
        merge(a,lo,mid,hi);
    }

    /**
     * 索引lo到所以mid为一个子组，从索引mid+1到索引hi为另一个子组，
     * 把数组a中的这两个子组的数据合并成一个有序的大组（从索引lo到索引hi）
     * @param a
     * @param lo
     * @param mid
     * @param hi
     */
    private static void merge(Comparable[] a, int lo, int mid, int hi) {
        // 三个指针，指向三个数组
        int p1 = lo, p2 = mid+1,i = lo;
        // 对两个数组进行比较，哪个小就放哪个
        while (p1 <= mid && p2 <= hi) {
            if (less(a[p1],a[p2])) {
                assist[i++] = a[p1++];
            } else {
                assist[i++] = a[p2++];
            }
        }
        // 将数组中剩余部分全部存进辅助数组
        while (p1 <= mid) {
            assist[i++] = a[p1++];
        }
        while (p2 <= hi) {
            assist[i++] = a[p2++];
        }
        //到现在为止，assist数组中，从lo到hi的元素是有序的，再把数据拷贝到a数组中对应的索引处
        for (int index=lo;index <= hi;index++){
            a[index] = assist[index];
        }
    }

    /**
     * 判断v是否小于w
     * @param v
     * @param w
     * @return
     */
    private static boolean less(Comparable v,Comparable w) {
        return v.compareTo(w) < 0;
    }

    /**
     * 交换a数组中，索引i和索引j处的值
     * @param a
     * @param i
     * @param j
     */
    private static void swap(Comparable[] a,int i,int j) {
        Comparable temp;
        temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
