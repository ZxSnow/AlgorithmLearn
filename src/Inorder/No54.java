package Inorder;

import java.util.ArrayList;
import java.util.List;

public class No54 {
    List<Integer> res;

    public List<Integer> spiralOrder(int[][] matrix) {
        res = new ArrayList<>();

        int m = matrix.length, n = matrix[0].length;

        circle(matrix, m, n, 0);

        return res;
    }

    public void circle(int[][] matrix, int row, int col, int level) {
        if (res.size() == matrix[0].length * matrix.length)
            return;

        for (int i = level; i < col; i++) {
            res.add(matrix[level][i]);
        }
        for (int i = level + 1; i < row; i++) {
            res.add(matrix[i][col - 1]);
        }
        if (res.size() == matrix[0].length * matrix.length)
            return;

        for (int i = col - 2; i >= level; i--) {
            res.add(matrix[row - 1][i]);
        }
        for (int i = row - 2; i > level; i--) {
            res.add(matrix[i][level]);
        }
        circle(matrix, row - 1, col - 1, level + 1);
    }

    public static void main(String[] args) {
        No54 no = new No54();
        int[][] m = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        List<Integer> res = no.spiralOrder(m);
        System.out.println(res.toString());
    }
}
