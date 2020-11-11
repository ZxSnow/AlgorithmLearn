package Backtrack;

public class WordSearch {
    /**
     * 单词搜索
     * 描述：给定一个二维网格和一个单词，找出该单词是否存在于网格中。
     * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
     * <p>
     * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-medium/xvkwe2。
     * 写的太不优雅了...
     */
    public boolean exist(char[][] board, String word) {
        boolean res;
        this.board = board;
        this.word = word;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    record = new int[board.length][board[0].length];
                    record[i][j] = 1;
                    res = help(i, j, word.substring(0, 1));
                    if (res) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    char[][] board;
    String word;
    int[][] record;

    public boolean help(int i, int j, String path) {
        if (path.equals(word)) {
            return true;
        }
        boolean res = false;
        //右 下 左 上
        if (board[i][j] != word.charAt(path.length() - 1)) {
            return false;
        }
        if (j < board[0].length - 1 && record[i][j + 1] == 0) {
            path += board[i][j + 1];
            int idx = path.length();
            record[i][j + 1] = 1;
            res = help(i, j + 1, path);
            if (res) {
                return true;
            }
            path = path.substring(0, idx - 1);
            record[i][j + 1] = 0;
        }
        if (i < board.length - 1 && record[i + 1][j] == 0) {
            path += board[i + 1][j];
            int idx = path.length();
            record[i + 1][j] = 1;
            res = help(i + 1, j, path);
            if (res) {
                return true;
            }
            path = path.substring(0, idx - 1);
            record[i + 1][j] = 0;
        }
        if (j > 0 && record[i][j - 1] == 0) {
            path += board[i][j - 1];
            int idx = path.length();
            record[i][j - 1] = 1;
            res = help(i, j - 1, path);
            if (res) {
                return true;
            }
            record[i][j - 1] = 0;
            path = path.substring(0, idx - 1);
        }
        if (i > 0 && record[i - 1][j] == 0) {
            path += board[i - 1][j];
            int idx = path.length();
            record[i - 1][j] = 1;
            res = help(i - 1, j, path);
            if (res) {
                return true;
            }
            path = path.substring(0, idx - 1);
            record[i - 1][j] = 0;
        }
        return false;
    }

    /**
     * somebody else
     */
    int m, n;
    char[] target;
    boolean res = false;

    public boolean exist1(char[][] board, String word) {
        m = board.length;
        n = board[0].length;
        target = word.toCharArray();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == target[0]) {
                    board[i][j] = '#';
                    dfs(board, i, j, 1);
                    board[i][j] = target[0];
                }
            }
        }
        return res;
    }

    public void dfs(char[][] board, int i, int j, int index) {
        if (res) return;
        if (index == target.length) {
            res = true;
            return;
        }
        if (i - 1 >= 0 && board[i - 1][j] == target[index]) {
            board[i - 1][j] = '#';
            dfs(board, i - 1, j, index + 1);
            board[i - 1][j] = target[index];
        }
        if (j - 1 >= 0 && board[i][j - 1] == target[index]) {
            board[i][j - 1] = '#';
            dfs(board, i, j - 1, index + 1);
            board[i][j - 1] = target[index];
        }
        if (i + 1 < m && board[i + 1][j] == target[index]) {
            board[i + 1][j] = '#';
            dfs(board, i + 1, j, index + 1);
            board[i + 1][j] = target[index];
        }
        if (j + 1 < n && board[i][j + 1] == target[index]) {
            board[i][j + 1] = '#';
            dfs(board, i, j + 1, index + 1);
            board[i][j + 1] = target[index];
        }
    }

    public static void main(String[] args) {
        String s = "ABC";
        char[][] board = {{'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}};
        WordSearch ws = new WordSearch();

        System.out.println(ws.exist(board, s));
    }
}
