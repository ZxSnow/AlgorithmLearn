package DynamicProgram.medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CoinChange {
    /**
     * 零钱兑换
     * https://leetcode-cn.com/leetbook/read/top-interview-questions-medium/xvf0kh/
     * 待备忘录的递归（自顶向下）
     */
    public Map<Integer, Integer> memo = new HashMap<>();

    public int coinChange(int[] coins, int amount) {
        if (memo.containsKey(amount)) {
            return memo.get(amount);
        }
        if (amount == 0) {
            return 0;
        } else if (amount < 0) {
            return -1;
        }
        int res = Integer.MAX_VALUE;

        for (int coin : coins) {
            int sub = coinChange(coins, amount - coin);
            if (sub < 0) {
                continue;
            }
            res = Math.min(res, 1 + sub);
        }

        if (res == Integer.MAX_VALUE) {
            res = -1;
        }
        memo.put(amount, res);
        return res;
    }

    public int coinChange1(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount);
        dp[0] = 0;

        for (int i = 0; i < dp.length; i++) {
            for (int coin : coins) {
                if (i - coin < 0) {
                    continue;
                }
                dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
            }
        }
        int res = -1;
        if (dp[amount] != amount + 1) {
            res = dp[amount];
        }
        return res;
    }

    public static void main(String[] args) {

    }
}
