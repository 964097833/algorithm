package cn.yqd.zuo.basic;

/**
 * 使用固定数组实现栈
 * @Author yuqiaodi
 * @Date 2020/8/19 9:23
 * @Version 1.0
 */
public class ArrayStack {

    int[] arr;
    int index;

    public ArrayStack(int size) {
        if (size < 0) {
            throw new IllegalArgumentException("The init size is less than 0");
        }
        arr = new int[size];
        index = 0;
    }

    public void push(int num) {
        if (index == arr.length) {
            throw new ArrayIndexOutOfBoundsException("The queue is full");
        }
        arr[index++] = num;
    }

    public Integer pop() {
        if (index == 0) {
            throw new ArrayIndexOutOfBoundsException("The queue is empty");
        }
        return arr[--index];
    }

    public Integer peek() {
        if (index == 0) {
            return null;
        }
        return arr[index - 1];
    }

}


