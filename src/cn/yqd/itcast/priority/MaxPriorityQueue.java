package cn.yqd.itcast.priority;


public class MaxPriorityQueue<T extends Comparable<T>> {
    private T[] items;
    private int N;
    /**
     * 创建容量为capacity的MaxPriorityQueue对象
     * @param capacity
     */
    public MaxPriorityQueue(int capacity) {
        this.items = (T[]) new Comparable[capacity+1];
        this.N=0;
    }

    /**
     * 删除队列中最大的元素,并返回这个最大元素
     * @return
     */
    public T delMax() {
        T max = items[1];
        swap(1,N);
        items[N]=null;
        N--;
        sink(1);
        return max;
    }

    /**
     * 往队列中插入一个元素
     * @param t
     */
    public void insert(T t) {
        items[++N] = t;
        swim(N);
    }

    /**
     * 使用上浮算法，使索引k处的元素能在堆中处于一个正确的位置
     * @param k
     */
    private void swim(int k) {
        while (k>1) {
            if (less(k/2,k)) {
                swap(k/2,k);
            } else {
                break;
            }
            k = k/2;
        }
    }

    /**
     * 使用下沉算法，使索引k处的元素能在堆中处于一个正确的位置
     * @param k
     */
    private void sink(int k) {
        int max;
        while (k*2 <= N) {
            if (k*2+1 <= N) {
                if (less(k*2,k*2+1)) {
                    max = k*2+1;
                } else {
                    max = k*2;
                }
            } else {
                max = k*2;
            }
            if (!less(k,max)) break;
            swap(k,max);
            k = max;
        }
    }
    public int size() {
        return N;
    }
    public boolean isEmpty() {
        return this.N == 0;
    }
    private boolean less(int i,int j) {
        return items[i].compareTo(items[j]) < 0;
    }
    private void swap(int i,int j) {
        T temp = items[i];
        items[i] = items[j];
        items[j] = temp;
    }
}
