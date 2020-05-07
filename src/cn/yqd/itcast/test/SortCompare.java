package cn.yqd.itcast.test;

import cn.yqd.itcast.sort.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class SortCompare {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        //读取reverse_arr.txt文件
        try (BufferedReader br = new BufferedReader(
                new FileReader("src\\reverse_arr.txt"))) {
            String line;
            //把每一个数字存入到集合中
            while ((line=br.readLine())!=null) {
                list.add(Integer.parseInt(line));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        //把集合转换成数组
        Integer[] arr = new Integer[list.size()];
        list.toArray(arr);

//        testBubble(arr);
//        testSelection(arr);
        testInsertion(arr);
//        testShell(arr);
//        testMergel(arr);

    }

    /**
     * 测试选择排序
     * @param arr
     */
    public static void testBubble(Integer[] arr) {
        // 1.获取开始时间
        long start = System.currentTimeMillis();
        // 2.运行排序算法
        Bubble.sort(arr);
        // 3.获取结束时间，并计算出耗时
        long end = System.currentTimeMillis();
        System.out.println("冒泡算法耗时为：" + (end-start) + "毫秒。");
    }

    /**
     * 测试选择排序
     * @param arr
     */
    public static void testSelection(Integer[] arr) {
        // 1.获取开始时间
        long start = System.currentTimeMillis();
        // 2.运行排序算法
        Selection.sort(arr);
        // 3.获取结束时间，并计算出耗时
        long end = System.currentTimeMillis();
        System.out.println("选择算法耗时为：" + (end-start) + "毫秒。");
    }

    /**
     * 测试插入排序
     * @param arr
     */
    public static void testInsertion(Integer[] arr) {
        // 1.获取开始时间
        long start = System.currentTimeMillis();
        // 2.运行排序算法
        Insertion.sort(arr);
        // 3.获取结束时间，并计算出耗时
        long end = System.currentTimeMillis();
        System.out.println("插入算法耗时为：" + (end-start) + "毫秒。");
    }

    /**
     * 测试希尔排序
     * @param arr
     */
    public static void testShell(Integer[] arr) {
        // 1.获取开始时间
        long start = System.currentTimeMillis();
        // 2.运行排序算法
        Shell.sort(arr);
        // 3.获取结束时间，并计算出耗时
        long end = System.currentTimeMillis();
        System.out.println("希尔算法耗时为：" + (end-start) + "毫秒。");
    }

    /**
     * 测试归并排序
     * @param arr
     */
    public static void testMergel(Integer[] arr) {
        // 1.获取开始时间
        long start = System.currentTimeMillis();
        // 2.运行排序算法
        Merge.sort(arr);
        // 3.获取结束时间，并计算出耗时
        long end = System.currentTimeMillis();
        System.out.println("归并算法耗时为：" + (end-start) + "毫秒。");
    }
}
