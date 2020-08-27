package cn.yqd.zuo.basic;

/**
 * “之”字形打印矩阵
 * 【题目】 给定一个矩阵matrix，按照“之”字形的方式打印这
 * 个矩阵，例如： 1 2 3 4 5 6 7 8 9 10 11 12
 * “之”字形打印的结果为：1，2，5，9，6，3，4，7，10，11，
 * 8，12
 * 【要求】 额外空间复杂度为O(1)。
 * @Author yuqiaodi
 * @Date 2020/8/20 14:09
 * @Version 1.0
 */
public class Code_12_ZigZagPrintMatrix {

    public static void printMatrixZigZag(int[][] matrix) {
        int aR = 0;
        int aC = 0;
        int bR = 0;
        int bC = 0;
        int endR = matrix.length - 1;
        int endC = matrix[0].length - 1;
        boolean fromUp = false;
        while (aR <= endR) {
            printLevel(matrix, aR, aC, bR, bC, fromUp);
            aR = aC == endC ? aR + 1 : aR;
            aC = aC == endC ? aC : aC + 1;
            bC = bR == endR ? bC + 1 : bC;
            bR = bR == endR ? bR : bR + 1;
            fromUp = !fromUp;
        }
    }

    private static void printLevel(int[][] matrix, int aR, int aC, int bR, int bC, boolean fromUp) {
        if (fromUp) {
            while (aR <= bR) {
                System.out.print(matrix[aC--][aR++] + " ");
            }
        } else {
            while (aR <= bR) {
                System.out.print(matrix[bC++][bR--] + " ");
            }
        }
    }

    public static void main(String[] args) {
        int[][] arr = {
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12},
                {13,14,15,16}
        };
        printMatrixZigZag(arr);
    }

}
