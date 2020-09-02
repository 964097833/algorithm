package cn.yqd.zuo.basic;

import cn.yqd.zuo.util.CheckDataUtil;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @Author yuqiaodi
 * @Date 2020/8/19 16:38
 * @Version 1.0
 */
public class Code_14_StackToQueue {

    private Stack<Integer> pushStack;
    private Stack<Integer> popStack;

    public Code_14_StackToQueue() {
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

    /**
     * 1.从push栈往pop栈倒数据的时候，pop必须为空才能执行此操作
     * 2.倒数据时一定要倒倒push栈为空才停止
     * 3.只要满足以上两个条件，任何时候都可以进行倒数据的操作
     */
    private void invert() {
        if (!popStack.isEmpty()) {
            return;
        }
        while (!pushStack.isEmpty()) {
            popStack.push(pushStack.pop());
        }
    }

    /**
     * =========================================
     * 对数器
     */
    public static void main(String[] args) {
        int testTime = 500000;
        int size = 10;
        int value = 100;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            Code_14_StackToQueue stackToQueue = new Code_14_StackToQueue();
            Queue<Integer> queue = new LinkedList<>();
            int[] arr = CheckDataUtil.generateRandomArray(size, value);
            for (int j = 0; j < arr.length; j++) {
                stackToQueue.enqueue(arr[j]);
                queue.add(arr[j]);
            }
            while (!queue.isEmpty()) {
                if (!queue.remove().equals(stackToQueue.dequeue())) {
                    CheckDataUtil.printArray(arr);
                    succeed = false;
                    break;
                }
            }
        }
        System.out.println(succeed ? "Nice!" : "error...");
    }

}
