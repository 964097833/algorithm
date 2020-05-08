package cn.yqd.itcast.heap;

/**
 * 堆
 * @param <T>
 */
public class Heap<T extends Comparable<T>> {
    private T[] items;
    private int N;

    /**
     * 创建容量为capacity的Heap对象
     * @param capacity
     */
    public Heap(int capacity){
        items = (T[]) new Comparable[capacity+1];
        this.N=0;
    }

    /**
     * 判断堆中索引i处的元素是否小于索引j处的元素
     * @param i
     * @param j
     * @return
     */
    private boolean less(int i,int j){
        return items[i].compareTo(items[j]) < 0;
    }

    /**
     * 交换堆中i索引和j索引处的值
     * @param i
     * @param j
     */
    private void swap(int i,int j){
        T temp;
        temp = items[i];
        items[i] = items[j];
        items[j] = temp;
    }

    /**
     * 往堆中插入一个元素
     * @param t
     */
    public void insert(T t){
        items[++N] = t;
        swim(N);
    }

    /**
     * 使用上浮算法，使索引k处的元素能在堆中处于一个正确的位置
     * @param k
     */
    private void swim(int k){
        // 如果已经达到根节点则不再循环
        while (k>1) {
            // 比较当前结点及其父结点大小
            if (less(k/2,k)) {
                // 父结点小于当前结点则需要交换
                swap(k/2,k);
                k = k/2;
            } else {
                // 不小于代表堆有序
                break;
            }
        }
    }

    /**
     * 删除堆中最大的元素,并返回这个最大元素
     * @return 返回被删除元素
     */
    public T delMax(){
        // max存储删除元素的值
        T max = items[1];
        // 将最后一个元素放到根节点，根结点元素放到N索引位置
        swap(1,N);
        // 删除最大的元素
        items[N] = null;
        // 堆长度减一
        N--;
        // 使删除后的堆有序
        sink(1);
        return max;
    }

    /**
     * 使用下沉算法，使索引k处的元素能在堆中处于一个正确的位置
     * @param k
     */
    private void sink(int k){
        // k*2<=N是当K下面起码还有一个结点时，继续循环
        while (k*2 <= N) {
            // max存放两个结点中较大的结点索引
            int max;
            // 当存在两个结点时，比较两个结点的大小，将较大结点的索引放进max
            if (k*2+1 <= N) {
                if (less(k*2,k*2+1)) {
                    max = k*2+1;
                } else {
                    max = k*2;
                }
            } else {
                // 只存在一个索引，直接放进max
                max = k*2;
            }
            // 比较K结点与较大结点的大小，如果k不小于max结点则结束循环，堆已有序
            if (!less(k,max)) {
                break;
            }
            // 否则交换两个结点
            swap(k,max);
            // k定位到max索引位置
            k=max;
        }
    }
}
