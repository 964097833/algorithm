package cn.yqd.zuo.basic;

/**
 * @description:岛问题
 * 一个矩阵中只有0和1两种值，每个位置都可以和自己的上、下、左、右四个位置相连，
 * 如果有一片1连在一起，这个部分叫做一个岛，
 * 求一个矩阵中有多少个岛？
 * 举例：
 * 0 0 1 0 1 0
 * 1 1 1 0 1 0
 * 1 0 0 1 0 0
 * 0 0 0 0 0 0
 * 这个矩阵中有三个岛。
 * @author: yuqiaodi
 * @date: 2020/9/15 9:23
 */
public class Code_27_Islands {

    private static int countIslands(int[][] m) {
        if (m == null || m[0] == null) {
            return 0;
        }
        int N = m.length;
        int M = m[0].length;
        int res = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (m[i][j] == 1) {
                    res++;
                    infect(m, i, j, N, M);
                }
            }
        }
        return res;
    }

    /** 一个感染函数，当出现数组中值为1时，就会把该点的上下左右的1都感染为2 */
    private static void infect(int[][] m, int i, int j, int N, int M) {
        // 当出现到达数组边界，或者当前位置不是1的时候则退出
        if (i < 0 || i > N || j < 0 || j > M || m[i][j] != 1) {
            return;
        }
        // 已经感染过的1的位置标志为2
        m[i][j] = 2;
        // 向四周扩散
        infect(m, i, j - 1, N, M);
        infect(m, i, j + 1, N, M);
        infect(m, i - 1, j, N, M);
        infect(m, i + 1, j, N, M);
    }

    public static void main(String[] args) {
        int[][] m1 = {  { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 1, 1, 1, 0, 1, 1, 1, 0 },
                { 0, 1, 1, 1, 0, 0, 0, 1, 0 },
                { 0, 1, 1, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 1, 1, 0, 0 },
                { 0, 0, 0, 0, 1, 1, 1, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0 }, };
        System.out.println(countIslands(m1));

        int[][] m2 = {  { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 1, 1, 1, 1, 1, 1, 1, 0 },
                { 0, 1, 1, 1, 0, 0, 0, 1, 0 },
                { 0, 1, 1, 0, 0, 0, 1, 1, 0 },
                { 0, 0, 0, 0, 0, 1, 1, 0, 0 },
                { 0, 0, 0, 0, 1, 1, 1, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0 }, };
        System.out.println(countIslands(m2));

    }

}
