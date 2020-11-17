package DynamicProgram.primary;

import java.util.Arrays;

public class Practice3 {
    /**
     * 最大子序和
     * https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xn3cg3/
     * 用nums[] 来表示了dp[]
     * dp[i]的含义表示为 以第i位元素结尾的最大子序列和
     * dp[i]的初始化为 元素本身
     * 转移的条件，因为最大子序的连续性，因此在计算dp[i]时，判断dp[i-1]是否>0,只有大于0时才把它们连接起来
     *
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        int res = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] > 0) {
                nums[i] += nums[i - 1];
            }
            res = Math.max(res, nums[i]);
        }
        return res;
    }
}
