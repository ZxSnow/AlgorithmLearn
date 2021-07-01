package Occur;

public class No1004 {
    /**
     * LeetCode 1004: 最大连续1的个数 III
     * https://leetcode-cn.com/problems/max-consecutive-ones-iii/
     */
    public int longestOnes(int[] nums, int k) {
        int left = 0, right = 0;
        int valid = 0;
        int max = 0;

        while (right < nums.length) {
            int cur = nums[right];
            right++;
            if (cur == 0) {
                valid++;
            }

            while (valid > k) {
                int le = nums[left];
                if (le == 0) {
                    valid--;
                }
                left++;
            }
            max = Math.max(right - left, max);
        }
        return max;
    }

    public static void main(String[] args) {
        No1004 no = new No1004();
        int[] nums = {0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1};
        int res = no.longestOnes(nums, 3);
        System.out.println(res);
    }
}
