package Inorder;

import java.util.Arrays;

public class No674 {
    public int findLengthOfLCIS(int[] nums) {
//        int[] dp = new int[nums.length];
//        Arrays.fill(dp, 1);
        int dp = 1;
        int max = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                dp = dp + 1;
            } else {
                dp = 1;
            }
            max = Math.max(max, dp);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 4, 7};

        No674 no = new No674();
        int res = no.findLengthOfLCIS(nums);
        System.out.println(res);
    }
}
