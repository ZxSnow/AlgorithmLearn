package DynamicProgram;

public class Practice1 {
    /**
     * 爬楼梯
     * https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xn854d/
     */
    public int climbStairs(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        Practice1 p = new Practice1();
        int rs = p.climbStairs(4);
        System.out.println(rs);
    }
}
