package DynamicProgram;

import java.util.Arrays;

public class No712 {
    public int minimumDeleteSum(String s1, String s2) {
        memo = new int[s1.length()][s2.length()];
        for (int[] m : memo) {
            Arrays.fill(m, -1);
        }
        return dp(s1, 0, s2, 0);
    }

    int[][] memo;

    public int dp(String s1, int i, String s2, int j) {
        int res = 0;
        if (i == s1.length()) {
            for (int m = j; m < s2.length(); m++) {
                res += s2.charAt(m);
            }
            return res;
        }
        if (j == s2.length()) {
            for (int m = i; m < s1.length(); m++) {
                res += s1.charAt(m);
            }
            return res;
        }
        if (memo[i][j] != -1)
            return memo[i][j];

        if (s1.charAt(i) == s2.charAt(j)) {
            memo[i][j] = dp(s1, i + 1, s2, j + 1);
        } else {
            memo[i][j] = Math.min(
                    dp(s1, i + 1, s2, j) + s1.charAt(i),
                    dp(s1, i, s2, j + 1) + s2.charAt(j)
            );
        }

        return memo[i][j];
    }
}
