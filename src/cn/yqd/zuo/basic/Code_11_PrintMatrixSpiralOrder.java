package cn.yqd.zuo.basic;

/**
 * @Author yuqiaodi
 * @Date 2020/8/20 10:45
 * @Version 1.0
 */
public class Code_11_PrintMatrixSpiralOrder {

    /**
     * 转圈打印矩阵
     * 【题目】 给定一个整型矩阵matrix，请按照转圈的方式打印它。
     * 例如： 1 2 3 4 5 6 7 8 9 10 11 12 13 14
     * 15 16 打印结果为：1，2，3，4，8，12，16，15，14，13，9，
     * 5，6，7，11， 10
     * 【要求】 额外空间复杂度为O(1)。
     * @param matrix
     */
    public static void spiralOrderPrint(int[][] matrix) {
        int tR = 0;
        int tC = 0;
        int dR = matrix.length - 1;
        int dC = matrix[0].length - 1;
        while (tR <= dR && tC <= dC) {
            printEdge(matrix, tR++, tC++, dR--, dC--);
        }
    }

    private static void printEdge(int[][] matrix, int tR, int tC, int dR, int dC) {

        int curR = tR;
        int curC = tC;
        if (curR == dR) {
            for (int i = curC; i <= dC; i++) {
                System.out.print(matrix[curR][i] + " ");
            }
        } else if (curC == dC) {
            for (int i = curR; i <= dR; i++) {
                System.out.print(matrix[i][curC] + " ");
            }
        } else {
            while (curC < dC) {
                System.out.print(matrix[curR][curC++] + " ");
            }
            while (curR < dR) {
                System.out.print(matrix[curR++][curC] + " ");
            }
            while (curC > tC) {
                System.out.print(matrix[curR][curC--] + " ");
            }
            while (curR > tR) {
                System.out.print(matrix[curR--][curC] + " ");
            }
        }
    }

    /**
     * 旋转正方形矩阵
     * 【题目】 给定一个整型正方形矩阵matrix，请把该矩阵调整成
     * 顺时针旋转90度的样子。
     * 【要求】 额外空间复杂度为O(1)。
     * @param matrix
     */
    public static void rotate(int[][] matrix) {
        int tR = 0;
        int tC = 0;
        int dR = matrix.length - 1;
        int dC = matrix[0].length - 1;
        while (tR < dR) {
            rotateEdge(matrix, tR++, tC++, dR--, dC--);
        }
    }

    private static void rotateEdge(int[][] matrix, int tR, int tC, int dR, int dC) {
        int times = dR - tR;
        for (int i = 0; i < times; i++) {
            int tmp = matrix[tR][tC + i];
            matrix[tR][tC + i] = matrix[dR - i][tC];
            matrix[dR - i][tC] = matrix[dR][dC - i];
            matrix[dR][dC - i] = matrix[tR + i][dC];
            matrix[tR + i][dC] = tmp;
        }
    }

    public static void main(String[] args) {
        int[][] arr = {
                {1,2,3,4},
                {12,13,14,5},
                {11,16,15,6},
                {10,9,8,7}
        };
        spiralOrderPrint(arr);
        rotate(arr);
        System.out.println();
        spiralOrderPrint(arr);
    }

}
