package cn.yqd.zuo.basic;

import java.util.Stack;

/**
 * @Author yuqiaodi
 * @Date 2020/8/19 16:38
 * @Version 1.0
 */
public class StackToQueue {

    private Stack<Integer> pushStack;
    private Stack<Integer> popStack;

    public StackToQueue() {
        pushStack = new Stack<>();
        popStack = new Stack<>();
    }

    public void enqueue(int num) {
        pushStack.push(num);
    }

    public Integer dequeue() {
        if (pushStack.isEmpty() && popStack.isEmpty()) {
            throw new RuntimeException("The queue is empty");
        }
        invert();
        return popStack.pop();
    }

    private void invert() {
        if (!popStack.isEmpty()) {
            return;
        }
        while (!pushStack.isEmpty()) {
            popStack.push(pushStack.pop());
        }
    }

    public static void main(String[] args) {
        StackToQueue stackToQueue = new StackToQueue();
        stackToQueue.enqueue(1);
        stackToQueue.enqueue(2);
        stackToQueue.enqueue(3);
        stackToQueue.enqueue(4);
        System.out.println(stackToQueue.dequeue());
        System.out.println(stackToQueue.dequeue());
        System.out.println(stackToQueue.dequeue());
        System.out.println(stackToQueue.dequeue());
        System.out.println(stackToQueue.dequeue());
    }

}
