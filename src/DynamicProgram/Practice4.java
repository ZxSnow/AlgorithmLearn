package DynamicProgram;

import java.util.Arrays;

public class Practice4 {

    public int rob(int[] nums) {
        int[][] dp = new int[nums.length][2];
        int max = 0;
        dp[0][0] = 0;
        dp[0][1] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
            dp[i][1] = dp[i - 1][0] + nums[i];
            max = Math.max(dp[i][0], dp[i][1]);
        }
        return Math.max(max, nums[0]);
    }

    public int rob1(int[] nums) {
        int rob = nums[0];
        int notRob = 0;
        int max = 0;
        for (int i = 1; i < nums.length; i++) {
            int temp = Math.max(rob, notRob);
            rob = notRob + nums[i];
            notRob = temp;
            max = Math.max(rob, temp);
        }
        return Math.max(max, nums[0]);
    }
}
