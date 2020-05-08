package cn.yqd.itcast.heap;

/**
 * 堆排序
 */
public class HeapSort {
    /**
     * 对source数组中的数据从小到大排序
     * @param source
     */
    public static void sort(Comparable[] source){
        Comparable[] heap = new Comparable[source.length + 1];
        // 将source中的元素写入heap中
        createHeap(source,heap);
        // 利用下沉来形成堆
        for (int i = heap.length/2; i >= 1; i--) {
            sink(heap,i,heap.length-1);
        }
        // 对堆进行排序，按从小到大输出。
        for (int i = heap.length-1; i > 1; i--) {
            swap(heap,1,i);
            sink(heap,1,i-1);
        }
        //把heap中的数据复制到原数组source中
        System.arraycopy(heap,1,source,0,source.length);
    }

    /**
     * 根据原数组source，构造出堆heap
     * @param source
     * @param heap
     */
    private static void createHeap(Comparable[] source, Comparable[] heap){
        for (int i = 0; i <= source.length-1; i++) {
            // 堆从下标1开始存数据
            heap[i+1] = source[i];
        }
    }

    /**
     * 判断heap堆中索引i处的元素是否小于索引j处的元素
     * @param heap
     * @param i
     * @param j
     * @return
     */
    private static boolean less(Comparable[] heap, int i, int j){
        return heap[i].compareTo(heap[j]) < 0;
    }

    /**
     * 交换heap堆中i索引和j索引处的值
     * @param heap
     * @param i
     * @param j
     */
    private static void swap(Comparable[] heap, int i, int j){
        Comparable temp;
        temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    /**
     * 在heap堆中，对target处的元素做下沉，范围是0~range。
     * @param heap
     * @param target
     * @param range
     */
    private static void sink(Comparable[] heap, int target, int range){
        while (target*2 <= range) {
            int max;
            if (target*2+1 <= range) {
                if (less(heap, target * 2, target * 2 + 1)) {
                    max = target * 2 + 1;
                } else {
                    max = target * 2;
                }
            } else {
                max = target*2;
            }
            if (!less(heap,target,max)){
                break;
            }
            swap(heap,target,max);
            target = max;
        }
    }
}
