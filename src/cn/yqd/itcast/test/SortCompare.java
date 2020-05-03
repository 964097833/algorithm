package cn.yqd.itcast.test;

import cn.yqd.itcast.sort.Insertion;
import cn.yqd.itcast.sort.Shell;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class SortCompare {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        //读取reverse_arr.txt文件
        try (BufferedReader br = new BufferedReader(
                new FileReader("D:\\Files\\project\\algorithm\\src\\reverse_arr.txt"))) {
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

        testInsertion(arr);
        testShell(arr);
    }

    public static void testInsertion(Integer[] arr) {
        // 1.获取开始时间
        long start = System.currentTimeMillis();
        // 2.运行排序算法
        Insertion.sort(arr);
        // 3.获取结束时间，并计算出耗时
        long end = System.currentTimeMillis();
        System.out.println("插入算法耗时为：" + (end-start) + "毫秒。");
    }

    public static void testShell(Integer[] arr) {
        // 1.获取开始时间
        long start = System.currentTimeMillis();
        // 2.运行排序算法
        Shell.sort(arr);
        // 3.获取结束时间，并计算出耗时
        long end = System.currentTimeMillis();
        System.out.println("希尔算法耗时为：" + (end-start) + "毫秒。");
    }
}
