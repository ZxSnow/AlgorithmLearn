package Array;

public class Practice2 {
    // TODO: 2019-10-17 太难了我自己想不出来

    /**
     * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
     * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
     * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
     * <p>
     * 实例：
     * 输入: [7,1,5,3,6,4]
     * 输出: 7
     * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
     * 随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6-3 = 3 。
     * <p>
     * 题目地址
     * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/1/array/22/
     * <p>
     * 题解
     * https://zhuanlan.zhihu.com/p/53246818
     */
    public static void main(String[] args) {

    }

    /**
     * labuladong算法学到的，向后找了一个最小的买入时间，然后做差找出最大值
     *
     * @param prices
     * @return
     */
    public int calculate0(int[] prices) {
        int result = 0;
        int minBug = prices[0];
        for (int sell = 1; sell < prices.length; sell++) {
            minBug = Math.min(minBug, prices[sell]);
            result = Math.max(result, prices[sell] - minBug);
        }
        return result;
    }

    /**
     * 暴力求解法
     *
     * @param prices
     * @param s      开始位置
     * @return
     */
    public int calculate(int[] prices, int s) {
        if (s >= prices.length)
            return 0;
        int max = 0;
        for (int start = s; start < prices.length; start++) {
            int maxProfit = 0;
            for (int i = start + 1; i < prices.length; i++) {
                if (prices[start] < prices[i]) {
                    //迭代计算
                    int profit = calculate(prices, i + 1) + prices[i] - prices[start];
                    if (profit > maxProfit)
                        maxProfit = profit;
                }
            }
            if (maxProfit > max)
                max = maxProfit;
        }
        return max;
    }

    public int peakValley0(int[] prices) {
        int i = 0;
        int valley = prices[0];
        int peak = prices[0];
        int maxprofit = 0;
        while (i < prices.length - 1) {
            while (i < prices.length - 1 && prices[i] >= prices[i + 1])
                i++;
            valley = prices[i];
            while (i < prices.length - 1 && prices[i] <= prices[i + 1])
                i++;
            peak = prices[i];
            maxprofit += peak - valley;
        }
        return maxprofit;
    }

    /**
     * 峰谷法
     *
     * @param prices
     * @return
     */
    public int peakValley(int[] prices) {
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1])
                maxProfit += prices[i] - prices[i - 1];
        }
        return maxProfit;
    }


}
