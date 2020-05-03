package cn.yqd.itcast.test;

import cn.yqd.itcast.sort.Student;

// 2.定义测试类Test，在测试类Test中定义测试方法Comparable getMax(Comparable c1,Comparable c2)完成测试
public class ComparableTest {
    public static void main(String[] args) {
        Student xiaoming = new Student("小明", 18);
        Student xiaohong = new Student("小红", 22);
        System.out.println(getMax(xiaoming,xiaohong));
    }

    public static Comparable getMax(Comparable c1, Comparable c2) {
        return c1.compareTo(c2)>0 ? c1 : c2;
    }
}
