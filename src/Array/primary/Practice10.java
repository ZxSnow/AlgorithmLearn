package Array.primary;

import java.util.HashMap;
import java.util.Map;

public class Practice10 {
    /**
     * 题目：有效的数独
     * <p>
     * 判断一个 9x9 的数独是否有效。只需要根据以下规则，验证已经填入的数字是否有效即可。
     * 数字 1-9 在每一行只能出现一次。
     * 数字 1-9 在每一列只能出现一次。
     * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
     * <p>
     * 题目地址：
     * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/1/array/30/
     */
    public static void main(String[] args) {
        char[][] array = {
                {'.', '8', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
        System.out.println(isValidSudoku(array));
    }

    public static boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            int index = 0;
            char[] array = new char[9];
            char[] array1 = new char[9];

            for (int j = 0; j < 9; j++) {
                array[index] = board[i][j];
                array1[index] = board[j][i];
                index++;
            }
            if (!check(array)) {
                return false;
            }
            if (!check(array1)) {
                return false;
            }
        }

        char[] array3 = new char[9];
        for (int row = 0; row < 9; row += 3) {
            for (int column = 0; column < 9; column += 3) {
                int index = 0;
                for (int i = row; i < row + 3; i++) {
                    for (int j = column; j < column + 3; j++) {
                        array3[index++] = board[i][j];
                    }
                }
                if (!check(array3)) {
                    return false;
                }
            }
        }

        return true;
    }

    private static boolean check(char[] array) {
        Map<Character, Character> map = new HashMap<>();
        for (char c : array) {
            if (c == '.') {
                continue;
            }
            if (map.containsKey(c)) {
                return false;
            }
            map.put(c, c);
        }
        return true;
    }

    /**
     * 别人的方法
     *
     * @param board
     * @return
     */
    public boolean isValidSudoku0(char[][] board) {
        int[] rows = new int[9];
        int[] columns = new int[9];
        int[] boxes = new int[9];
        for (int row = 0; row < 9; row++) {
            for (int column = 0; column < 9; column++) {
                char c = board[row][column];
                if (c == '.') {
                    continue;
                }
                int val = 1 << c - '1';
                int i = row / 3 * 3 + column / 3;
                if (((rows[row] | columns[column] | boxes[i]) & val) > 0) {
                    return false;
                }
                rows[row] |= val;
                columns[column] |= val;
                boxes[i] |= val;
            }
        }
        return true;
    }
}
