package Sort.medium;

import java.util.Arrays;

public class KthLargest {
    /**
     * 数组中的第K个最大元素
     * https://leetcode-cn.com/leetbook/read/top-interview-questions-medium/xvsehe/
     */
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }
}
