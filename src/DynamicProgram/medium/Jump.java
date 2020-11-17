package DynamicProgram.medium;

public class Jump {
    /**
     * 跳跃游戏
     * 给定一个非负整数数组，你最初位于数组的第一个位置。
     * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
     * 判断你是否能够到达最后一个位置
     * https://leetcode-cn.com/leetbook/read/top-interview-questions-medium/xvb8zs/
     */
    public boolean canJump(int[] nums) {
        if (nums.length == 0) {
            return false;
        }
        if (nums.length == 1) {
            return true;
        }
        int[] dp = new int[nums.length];
        if (nums[0] > 0) {
            dp[0] = 1;
        }
        for (int i = 0; i < nums.length - 1; i++) {
            if (dp[i] == 1) {
                int cnt = nums[i];
                for (; cnt > 0; cnt--) {
                    if (i + cnt < nums.length && dp[i + cnt] == 0) {
                        dp[i + cnt] = 1;
                    }
                }
            }
        }
        return dp[nums.length - 1] == 1;
    }

    /**
     * 贪心算法
     *
     * @param nums
     * @return
     */
    public boolean canJump1(int[] nums) {
        int n = nums.length;
        int rightmost = 0;
        for (int i = 0; i < n; ++i) {
            if (i <= rightmost) {
                rightmost = Math.max(rightmost, i + nums[i]);
                if (rightmost >= n - 1) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Jump j = new Jump();
        int[] nums = {3, 2, 1, 0, 4};
        boolean res = j.canJump1(nums);
        System.out.println(res);
    }
}
