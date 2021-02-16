package DynamicProgram.medium;

import java.util.Arrays;

public class Lis {
    /**
     * 最长上升子序列
     * https://leetcode-cn.com/leetbook/read/top-interview-questions-medium/xwhvq3/
     */

    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len];
        Arrays.fill(dp, 1);

        for (int i = 1; i < len; i++) {
            for (int j = i; j >= 0; j--) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int max = 0;
        for (int cnt : dp) {
            max = Math.max(max, cnt);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {7,7,7,7,7,7,7};
        Lis lis = new Lis();
        System.out.println(lis.lengthOfLIS(nums));
    }
}
