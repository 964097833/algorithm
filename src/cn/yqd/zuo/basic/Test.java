package cn.yqd.zuo.basic;


import java.util.ArrayList;
import java.util.List;

/**
 * @Author yuqiaodi
 * @Date 2020/8/14 14:57
 * @Version 1.0
 */
public class Test {

    public static void main(String[] args) {

        List<String> platformList = new ArrayList<>();
        platformList.add("123");
        platformList.add("1");
        platformList.add("广州市政府信息共享平台");
        System.out.println(platformList.contains("123"));
        System.out.println(platformList.contains("广州市政府信息共享平台"));
        System.out.println(platformList.contains("23"));


    }

}
