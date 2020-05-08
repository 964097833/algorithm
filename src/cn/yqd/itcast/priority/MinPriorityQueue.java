package cn.yqd.itcast.priority;

/**
 * 最小优先队列（基于最小堆）
 * @param <T>
 */
public class MinPriorityQueue<T extends Comparable<T>> {
    private T[] items;
    private int N;

    public MinPriorityQueue(int capacity) {
        this.items = (T[]) new Comparable[capacity+1];
        this.N=0;
    }

    private boolean less(int i,int j){
        return items[i].compareTo(items[j]) < 0;
    }

    private void swap(int i,int j){
        T temp = items[i];
        items[i] = items[j];
        items[j] = temp;
    }
    public T delMin(){
        T min = items[1];
        swap(1,N);
        N--;
        sink(1);
        return min;
    }
    public void insert(T t){
        items[++N] = t;
        swim(N);
    }
    private void swim(int k){
        while (k>1) {
            if (less(k,k/2)) {
                swap(k,k/2);
            } else {
                break;
            }
            k = k/2;
        }
    }
    private void sink(int k){
        int min;
        while (k*2 <= N) {
            if (k*2+1 <= N) {
                if (less(k*2,k*2+1)) {
                    min = k*2;
                } else {
                    min = k*2+1;
                }
            } else {
                min = k*2;
            }
            if (less(k,min)) break;
            swap(k,min);
            k = min;
        }
    }
    public int size(){
        return N;
    }
    public boolean isEmpty(){
        return N==0;
    }
}
