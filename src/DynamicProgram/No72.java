package DynamicProgram;

import java.util.Arrays;

public class No72 {
    /**
     * 编辑距离
     */
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        memo = new int[m][n];
        for (int[] ro : memo) {
            Arrays.fill(ro, -1);
        }
        return dp(word1, m - 1, word2, n - 1);
    }

    int[][] memo;

    public int dp(String s1, int i, String s2, int j) {
        if (i == -1)
            return j + 1;
        if (j == -1)
            return i + 1;
        if (memo[i][j] != -1) {
            return memo[i][j];
        }

        if (s1.charAt(i) == s2.charAt(j)) {
            memo[i][j] = dp(s1, i - 1, s2, j - 1);
        } else {
            memo[i][j] = Math.min(Math.min(
                            dp(s1, i - 1, s2, j),
                            dp(s1, i - 1, s2, j - 1)),
                    dp(s1, i, s2, j - 1));
        }

        return memo[i][j];
    }

    public int minDistance2(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i <= n; i++) {
            dp[0][i] = i;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 1 + min(
                            dp[i - 1][j], dp[i][j - 1], dp[i - 1][j - 1]
                    );
                }
            }
        }
        return dp[m][n];
    }

    public int min(int... nums) {
        int min = Integer.MAX_VALUE;
        for (int i : nums) {
            if (i < min) {
                min = i;
            }
        }
        return min;
    }
}
