package Array.primary;

import java.util.ArrayList;
import java.util.List;

public class Practice11 {
    /**
     * 题目：旋转图像
     * 给定一个 n × n 的二维矩阵表示一个图像。
     * 将图像顺时针旋转 90 度。
     * <p>
     * 说明：
     * 你必须在原地旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要使用另一个矩阵来旋转图像。
     * <p>
     * 题目地址：
     * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/1/array/31/
     */
    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}};
//        System.out.println(matrix.length);
        rotate(matrix);
        for (int[] ma : matrix) {
            for (int m : ma) {
                System.out.print(m + ",");
            }
            System.out.println();
        }
    }

    public static void rotate(int[][] matrix) {
        int length = matrix.length;
        //旋转次数
        int count;
        if (length % 2 != 0) {
            count = (length - 1) / 2;
        } else {
            count = length / 2;
        }
        for (int i = 0; i < count; i++) {
            List<Integer> list = new ArrayList<>();
            //length - 2i :旋转层的阶数
            int step = length - 2 * i;
            for (int j = 0; j < step - 1; j++) {
                //保存水平行数据，将剩余行列进行旋转
//                list.add(matrix[i][j]);
                int temp = matrix[i][j + i];
                //将④复制给①
                matrix[i][j + i] = matrix[step - j + i - 1][i];
                //将③赋值给④
                matrix[step - j + i - 1][i] = matrix[step - 1 + i][step - j + i - 1];
                //将②赋值给③
                matrix[step - 1 + i][step - j + i - 1] = matrix[j + i][step - 1 + i];
                //将①赋值给②
                matrix[j + i][step - 1 + i] = temp;
            }
        }
    }

    public void rotate0(int[][] matrix) {
        int length = matrix.length;
        //沿对角线交换
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                int t = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = t;
            }
        }
        //沿对称轴交换
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length / 2; j++) {
                int t = matrix[i][j];
                matrix[i][j] = matrix[i][length - j - 1];
                matrix[i][length - j - 1] = t;
            }
        }
    }

}
