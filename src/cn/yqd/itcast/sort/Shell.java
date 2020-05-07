package cn.yqd.itcast.sort;

/**
 * 希尔排序
 */
public class Shell {
    /**
     * 排序方法
     * @param a 待排序数组
     */
    public static void sort(Comparable[] a) {
        // 确定增长量h的最大值
        int h = 1;
        while (h<a.length/2) {
            h = 2 * h + 1;
        }

        //2.希尔排序
        while(h>=1){
            //排序
            //2.1.找到待插入的元素
            for (int i=h;i<a.length;i++){
                //2.2把待插入的元素插入到有序数列中
                for (int j=i;j>=h;j-=h){

                    //待插入的元素是a[j],比较a[j]和a[j-h]
                    if (greater(a[j-h],a[j])){
                        //交换元素
                        swap(a,j-h,j);
                    }else{
                        //待插入元素已经找到了合适的位置，结束循环；
                        break;
                    }
                }

            }
            //减小h的值
            h= h/2;
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
