package Sort.medium;

import Util.Utils;

import java.util.Arrays;
import java.util.Random;

public class KthLargest {
    /**
     * 数组中的第K个最大元素
     * https://leetcode-cn.com/leetbook/read/top-interview-questions-medium/xvsehe/
     */
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

    public int findKthLargest1(int[] nums, int k) {
        return quick(nums, 0, nums.length - 1, nums.length - k);
    }

    public int quick(int[] nums, int left, int right, int idx) {
        int p = random(nums, left, right);
        if (p == idx) {
            return nums[p];
        }
        if (p < idx)
            return quick(nums, p + 1, right, idx);
        return quick(nums, left, p - 1, idx);
    }

    Random rdm = new Random();

    public int random(int[] nums, int left, int right) {
        int i = rdm.nextInt(right - left + 1) + left;
        Utils.swap(nums, i, left);

        return partition(nums, left, right);
    }

    public int partition(int[] nums, int left, int right) {
        int cnt = left;
        int tmp = nums[left];
        for (int i = left + 1; i <= right; i++) {
            if (nums[i] < tmp) {
                Utils.swap(nums, ++cnt, i);
            }
        }
        Utils.swap(nums, left, cnt);
        return cnt;
    }
}
