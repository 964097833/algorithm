package cn.yqd.zuo.basic;

import netscape.security.UserTarget;

import java.beans.IntrospectionException;

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
        size = 0;
        first = 0;
        last = 0;
    }

    public void push(int num) {
        if (size == arr.length) {
            throw new ArrayIndexOutOfBoundsException("The queue is full");
        }
        size++;
        arr[last] = num;
        last = last == arr.length - 1 ? 0 : last + 1;
    }

    public Integer poll() {
        if (size == 0) {
            throw new ArrayIndexOutOfBoundsException("The queue is empty");
        }
        size--;
        int tmp = first;
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
