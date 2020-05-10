package cn.yqd.itcast.test;

import cn.yqd.itcast.uf.UF;

import java.util.Scanner;

public class UFTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入并查集中元素的个数：");
        int N = sc.nextInt();
        UF uf = new UF(N);
        while (true) {
            System.out.println("请输入您要合并的第一个结点：");
            int p = sc.nextInt();
            System.out.println("请输入您要合并的第一个结点：");
            int q = sc.nextInt();

            if (uf.connected(p, q)) {
                System.out.println(p+"结点与"+q+"结点已经在同一个分组里");
                continue;
            }

            uf.union(p, q);
            System.out.println("总共还有"+uf.count()+"个分组");
        }
    }
}
