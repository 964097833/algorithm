package cn.yqd.itcast.test;

import cn.yqd.itcast.sort.Selection;

import java.util.Arrays;

public class SelectionTest {
    public static void main(String[] args) {
        Integer[] a = {4,6,8,7,9,2,10,1,1,2,9,8,7,6,5,4,3,2};
        Selection.sort(a);
        System.out.println(Arrays.toString(a));
    }
}
