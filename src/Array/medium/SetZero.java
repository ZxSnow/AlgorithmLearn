package Array.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SetZero {
    /**
     * https://leetcode-cn.com/leetbook/read/top-interview-questions-medium/xvmy42/
     */
    public void setZeroes(int[][] matrix) {
        List<Integer> row = new ArrayList<>();
        List<Integer> line = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    row.addAll(Collections.singleton(i));
                    line.addAll(Collections.singleton(j));
                }
            }
        }
        for (Integer i : row) {
            for (int j = 0; j < matrix.length; j++) {
                matrix[i][j] = 0;
            }
        }
        for (Integer i : line) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[j][i] = 0;
            }
        }
    }

    public static void main(String[] args) {
        int[][] m = {{0, 1}};
        SetZero sz = new SetZero();
        sz.setZeroes(m);
    }
}
