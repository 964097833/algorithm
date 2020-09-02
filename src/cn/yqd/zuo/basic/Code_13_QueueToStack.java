package cn.yqd.zuo.basic;

import cn.yqd.zuo.util.CheckDataUtil;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 仅用队列结构实现栈结构
 * @Author yuqiaodi
 * @Date 2020/8/19 16:12
 * @Version 1.0
 */
public class Code_13_QueueToStack {
    private Queue<Integer> queue;
    private Queue<Integer> help;

    public Code_13_QueueToStack() {
        queue = new LinkedList<>();
        help = new LinkedList<>();
    }

    public void push(int num) {
        queue.add(num);
    }

    public Integer pop() {
        if (queue.isEmpty()) {
            throw new RuntimeException("The stack is empty");
        }
        // 将queue队列中的size-1个数放进help队列中
        while (queue.size() > 1) {
            help.add(queue.remove());
        }
        // 拿出queue队列中的最后一个数，保存进res变量
        int res = queue.remove();
        swap();
        return res;
    }

    /** 交换两个队列的引用 */
    private void swap() {
        Queue<Integer> tmp = queue;
        queue = help;
        help = tmp;
    }

    /**
     * =========================================
     * 对数器
     */
    public static void main(String[] args) {
        int testTime = 50000;
        int size = 5;
        int value = 100;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            Code_13_QueueToStack queueToStack = new Code_13_QueueToStack();
            Stack<Integer> stack = new Stack<>();
            int[] arr = CheckDataUtil.generateRandomArray(size, value);
            for (int j = 0; j < arr.length; j++) {
                queueToStack.push(arr[j]);
                stack.push(arr[j]);
            }
            while (!stack.isEmpty()) {
                if (!queueToStack.pop().equals(stack.pop())) {
                    succeed = false;
                    CheckDataUtil.printArray(arr);
                    break;
                }
            }
        }
        System.out.println(succeed ? "Nice!" : "error...");
    }

}
