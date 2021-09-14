package Inorder;

import java.util.*;

public class No45 {
    public int jump(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i < nums.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (nums[j] >= (i - j))
                    dp[i] = Math.min(dp[i], dp[j] + 1);
            }
        }
        return dp[nums.length - 1];
    }

    /**
     * 贪心
     *
     * @param nums
     * @return
     */
    public int jump2(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < Math.min(nums[i] + i + 1, nums.length); j++) {
                dp[j] = Math.min(dp[j], dp[i] + 1);
                if (j == nums.length - 1)
                    break;
            }
        }
        return dp[nums.length - 1];
    }

    public static void main(String[] args) {
        No45 no = new No45();
        int[] nums = {2, 3, 0, 1, 4};
        int res = no.jump2(nums);
        System.out.println(res);
    }
}
