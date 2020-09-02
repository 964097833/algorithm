package cn.yqd.zuo.basic;

import cn.yqd.zuo.util.CheckDataUtil;

import java.util.Arrays;
import java.util.Stack;

/**
 * @Author yuqiaodi
 * @Date 2020/8/19 10:08
 * @Version 1.0
 */
public class Code_12_MinStack {

    private Stack<Integer> data;
    /** 用来存储当前data栈中最小的值 */
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

    /**
     * =========================================
     * 对数器
     */
    public static void main(String[] args) {
        int testTime = 500000;
        int size = 5;
        int value = 100;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = generateRandomArray(size, value);
            int[] arr2 = CheckDataUtil.copyArray(arr1);
            int[] arr3 = CheckDataUtil.copyArray(arr1);
            Code_12_MinStack minStack = new Code_12_MinStack();
            for (int i1 = 0; i1 < arr1.length; i1++) {
                minStack.push(arr1[i1]);
            }
            CheckDataUtil.rightMethod(arr2);
            if (minStack.getMin() != arr2[0]) {
                succeed = false;
                System.out.println(minStack.getMin());
                System.out.println(arr2[0]);
                CheckDataUtil.printArray(arr3);
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "error...");
        int[] arr = generateRandomArray(size, value);
        CheckDataUtil.printArray(arr);
        Code_12_MinStack minStack2 = new Code_12_MinStack();
        for (int i = 0; i < arr.length; i++) {
            minStack2.push(arr[i]);
        }
        System.out.println(minStack2.getMin());
        CheckDataUtil.rightMethod(arr);
        System.out.println(arr[0]);
    }

    /**
     * 随机样本产生器(不产生size为0的数组)
     * @param size 数组大小
     * @param value 数据范围
     * @return 返回随机产生的数组
     */
    public static int[] generateRandomArray(int size, int value) {
        //Math.random() -> double[0,1)
        //(int)((size + 1) * Math.random()) -> [0,size]整数
        // 生成长度随机[1,size+1]的数组
        int[] arr = new int[(int) ((size + 1) * Math.random()) + 1];
        for (int i = 0; i < arr.length; i++) {
            // [-value, value]之间的随机数
            arr[i] = (int)((value+1) * Math.random()) - (int)((value+1) * Math.random());
        }
        return arr;
    }

}
