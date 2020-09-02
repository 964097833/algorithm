package cn.yqd.zuo.basic;

/**
 * @Author yuqiaodi
 * @Date 2020/8/19 9:50
 * @Version 1.0
 */
public class Code_11_ArrayQueue {

    private Integer[] arr;
    private Integer size;
    private Integer first;
    private Integer last;

    public Code_11_ArrayQueue(int initSize) {
        arr = new Integer[initSize];
        // 队列当前的size
        size = 0;
        // 队列的当前的第一的位置
        first = 0;
        // 队列中的最后一个位置
        last = 0;
    }

    public void push(int num) {
        if (size == arr.length) {
            throw new ArrayIndexOutOfBoundsException("The queue is full");
        }
        size++;
        arr[last] = num;
        // 如果last指针已经走到数组最后的位置，则让last指向0位置，复用数组中已经出队列的位置，否则last继续往后走
        last = last == arr.length - 1 ? 0 : last + 1;
    }

    public Integer poll() {
        if (size == 0) {
            throw new ArrayIndexOutOfBoundsException("The queue is empty");
        }
        size--;
        int tmp = first;
        // 如果first指针已经走到数组最后的位置，则让first指向0位置，否则first继续往后走
        first = first == arr.length - 1 ? 0 : first + 1;
        return arr[tmp];
    }

    public Integer peek() {
        if (size == 0) {
            throw new ArrayIndexOutOfBoundsException("The queue is empty");
        }
        return arr[first];
    }

}
