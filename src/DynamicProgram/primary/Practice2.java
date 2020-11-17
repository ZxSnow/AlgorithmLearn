package DynamicProgram.primary;

public class Practice2 {
    /**
     * 买卖股票（只交易一次）
     * https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xn8fsh/
     */
    public int maxProfit(int[] prices) {
        if (prices.length == 0) return 0;
        int res = 0;
        int minBuy = prices[0];
        for (int i = 1; i < prices.length; i++) {
            minBuy = Math.min(minBuy, prices[i]);
            res = Math.max(res, prices[i] - minBuy);
        }
        return res;
    }
}
