package Occur;

public class No926 {
    public int minFlipsMonoIncr(String s) {
        int n = s.length();
        int[][] dp = new int[n + 1][2];
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '0') {
                dp[i + 1][0] = dp[i][0];
                dp[i + 1][1] = Math.min(dp[i][0], dp[i][1] + 1);
            } else {
                dp[i + 1][0] = dp[i][0] + 1;
                dp[i + 1][1] = Math.min(dp[i][0], dp[i][1]);
            }

        }
        return Math.min(dp[n][0], dp[n][1]);
    }

    public int minFlipsMonoIncr1(String s) {
        int n = s.length();
        int dp0 = 0, dp1 = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '0') {
                dp1 = Math.min(dp0, dp1 + 1);
            } else {
                dp1 = Math.min(dp0++, dp1);
            }
        }
        return Math.min(dp0, dp1);
    }

    public static void main(String[] args) {
        No926 no = new No926();
        String s = "00011000";
        int res = no.minFlipsMonoIncr1(s);
        System.out.println(res);
    }
}
