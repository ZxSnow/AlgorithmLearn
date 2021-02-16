package DynamicProgram.medium;

public class UniquePaths {
    /**
     * 不同路径
     * https://leetcode-cn.com/leetbook/read/top-interview-questions-medium/xvjigd/
     */
    /**
     * 递归方式，会超时
     *
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths(int m, int n) {
        totalCol = m;
        totalRow = n;
        return help(0, 0);
    }

    int totalRow = 0;
    int totalCol = 0;

    public int help(int row, int col) {
        if (row == totalRow - 1 && col == totalCol - 1) {
            return 1;
        }
        int right = 0;
        int down = 0;
        if (col + 1 < totalCol) {
            right = help(row, col + 1);
        }
        if (row + 1 < totalRow) {
            down = help(row + 1, col);
        }
        return right + down;
    }

    /**
     * 动规，从最后的位置反向填入每个位置的值
     *
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths1(int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        // dp数组初始化
        dp[m][n - 1] = 1;

        //逐层遍历
        int row = m - 1;
        int col = n - 1;
        while (row >= 0 && col >= 0) {
            travel(dp, row, col);
            row--;
            col--;
        }
        return dp[0][0];
    }

    public void travel(int[][] dp, int row, int col) {
        //更新行
        for (int i = col; i >= 0; i--) {
            dp[row][i] = dp[row][i + 1] + dp[row + 1][i];
        }
        //更新列
        for (int i = row; i >= 0; i--) {
            dp[i][col] = dp[i][col + 1] + dp[i + 1][col];
        }
    }

    public static void main(String[] args) {
        UniquePaths up = new UniquePaths();
        int res = up.uniquePaths1(3, 3);
        System.out.println(res);
    }
}
