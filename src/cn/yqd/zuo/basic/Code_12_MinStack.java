package cn.yqd.zuo.basic;

import java.util.Stack;

/**
 * @Author yuqiaodi
 * @Date 2020/8/19 10:08
 * @Version 1.0
 */
public class Code_12_MinStack {

    private Stack<Integer> data;
    private Stack<Integer> min;

    public Code_12_MinStack() {
        data = new Stack<>();
        min = new Stack<>();
    }

    public void push(int num) {
        data.push(num);
        min.push(!min.empty() && min.peek() < num ? min.peek() : num);
    }

    public Integer pop() {
        if (data.empty()) {
            throw new ArrayIndexOutOfBoundsException("The stack is empty");
        }
        min.pop();
        return data.pop();
    }

    public Integer getMin() {
        if (min.empty()) {
            throw new ArrayIndexOutOfBoundsException("The stack is empty");
        }
        return min.peek();
    }

    public static void main(String[] args) {
        Code_12_MinStack minStack = new Code_12_MinStack();
        minStack.push(3);
        minStack.push(2);
        minStack.push(1);
        System.out.println(minStack.getMin());
        System.out.println(minStack.pop());
        System.out.println(minStack.getMin());
    }

}
