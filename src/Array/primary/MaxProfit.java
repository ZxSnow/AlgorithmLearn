package Array.primary;

public class MaxProfit {

    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][2];
        dp[0][1] = -prices[0];

        for (int i = 1; i < prices.length; i++) {

            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][0] - prices[i], dp[i - 1][1]);
        }

        return dp[prices.length - 1][0];
    }

    /**
     * 对dp进行状态压缩
     * 由于下一刻的转移只与当前的两个状态有关
     *
     * @param prices
     * @return
     */
    public int maxProfit2(int[] prices) {
        int dp_i_0 = 0;
        int dp_i_1 = -prices[0];

        for (int i = 1; i < prices.length; i++) {
            dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);
            dp_i_1 = Math.max(dp_i_1, dp_i_0 - prices[i]);
        }

        return dp_i_0;
    }

    public static void main(String[] args) {
        int[] arry = {1, 2, 3, 4, 5};
        MaxProfit mp = new MaxProfit();
        System.out.println(mp.maxProfit2(arry));
    }
}
