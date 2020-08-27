package cn.yqd.zuo.basic;

import cn.yqd.itcast.linear.LinkList;
import cn.yqd.itcast.linear.Queue;

/**
 * @Author yuqiaodi
 * @Date 2020/8/19 16:12
 * @Version 1.0
 */
public class QueueToStack {
    private Queue<Integer> queue;
    private Queue<Integer> help;

    public QueueToStack() {
        queue = new Queue<>();
        help = new Queue<>();
    }

    public void push(int num) {
        queue.enqueue(num);
        System.out.println("队列长度："+queue.size());
    }

    public Integer pop() {
        if (queue.isEmpty()) {
            throw new RuntimeException("The stack is empty");
        }
        while (queue.size() > 1) {
            help.enqueue(queue.dequeue());
        }
        int res = queue.dequeue();
        swap();
        System.out.println("队列长度："+queue.size());
        return res;
    }

    private void swap() {
        Queue<Integer> tmp = queue;
        queue = help;
        help = tmp;
    }

    public static void main(String[] args) {
        QueueToStack queueToStack = new QueueToStack();
        queueToStack.push(2);
        queueToStack.push(3);
        queueToStack.push(4);
        queueToStack.push(5);
        System.out.println(queueToStack.pop());
        System.out.println(queueToStack.pop());
        System.out.println(queueToStack.pop());
        System.out.println(queueToStack.pop());
    }
}
