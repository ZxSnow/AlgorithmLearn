package Inorder;

import java.util.Arrays;

public class No64 {
    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        dp = new int[m + 1][n + 1];
        Arrays.fill(dp[0], Integer.MAX_VALUE);
        for (int i = 0; i <= m; i++) {
            dp[i][0] = Integer.MAX_VALUE;
        }
        dp[0][1] = 0;
        for (int i = 0; i < Math.min(m, n); i++) {
            help(grid, i, m, n);
        }
        return dp[m][n];
    }

    int[][] dp;

    //更新一次
    public void help(int[][] grid, int start, int m, int n) {
        if (start >= m || start >= n) {
            return;
        }
        //向下更新
        for (int i = start; i < m; i++) {
            dp[i + 1][start + 1] = Math.min(dp[i + 1][start], dp[i][start + 1]) + grid[i][start];
        }

        for (int i = start + 1; i < n; i++) {
            dp[start + 1][i + 1] = Math.min(dp[start][i + 1], dp[start + 1][i]) + grid[start][i];
        }
    }

    public static void main(String[] args) {
        No64 no = new No64();
        int[][] grid = {{1, 2, 3}, {4, 5, 6}};
        int res = no.minPathSum(grid);
        System.out.println(res);
    }
}
