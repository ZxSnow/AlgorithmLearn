package DynamicProgram;

import java.util.Arrays;

public class LCS {
    public int longestCommonSubsequence(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();

        memo = new int[m][n];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }

        return dp(s1, 0, s2, 0);
    }

    int[][] memo;

    public int dp(String s1, int i, String s2, int j) {
        if (i == s1.length() || j == s2.length())
            return 0;

        if (memo[i][j] != -1) {
            return memo[i][j];
        }

        if (s1.charAt(i) == s2.charAt(j)) {
            memo[i][j] = 1 + dp(s1, i + 1, s2, i + 2);
        } else {
            memo[i][j] = Math.max(dp(s1, i + 1, s2, j), dp(s1, i, s2, j + 1));
        }

        return memo[i][j];
    }
}
