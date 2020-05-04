package cn.yqd.itcast.sort;

/**
 * 快速排序算法
 */
public class Quick {

    /**
     * 对数组内的元素进行排序
     * @param a
     */
    public static void sort(Comparable[] a) {
        int lo = 0;
        int hi = a.length-1;
        sort(a,lo,hi);
    }

    /**
     * 对数组a中从索引lo到索引hi之间的元素进排序
     * @param a
     * @param lo
     * @param hi
     */
    private static void sort(Comparable[] a, int lo, int hi) {
        // 递归的边界条件,数组中只能下两个数
        if (lo >= hi) return;
        // 调用partition方法返回一个分界值
        int part = partition(a,lo,hi);
        //分出来的两个数组继续进行切分
        sort(a,lo,part-1);
        sort(a,part+1,hi);
    }

    /**
     * 对数组a中，从索引 lo到索引 hi之间的元素进行分组，并返回分组界限对应的索引
     * @param a
     * @param lo
     * @param hi
     * @return
     */
    public static int partition(Comparable[] a,int lo,int hi) {
        // 选第一个数为基准数
        int key = lo;
        int left = lo;
        int right = hi+1;
        while (true) {
            // 从尾部向头部遍历，直到出现比基准数小的元素
            while (!less(a[--right],a[key])) {
                if (right <= left) break;
            }
            // 从头部向尾部遍历，直到出现比基准数大的元素
            while (less(a[++left],a[key])) {
                if (right <= left) break;
            }
            if (right <= left) {
                break;
            } else {
                swap(a,left,right);
            }
        }
        // 把分界值放到正确的位置
        swap(a,key,right);
        // 返回基准数此时的位置
        return right;
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
