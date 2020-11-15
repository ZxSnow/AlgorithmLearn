package Sort.medium;

import java.util.Arrays;

public class FirstAndLast {
    /**
     * 在排序数组中查找元素的第一个和最后一个位置
     * https://leetcode-cn.com/leetbook/read/top-interview-questions-medium/xv4bbv/
     */
    public int[] searchRange(int[] nums, int target) {
        int[] res = {-1, -1};
        int left = 0;
        int right = nums.length - 1;
        int mid = nums.length / 2;
        while (left <= right) {
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                int le = mid;
                while (le >= 0 && nums[le] == target) {
                    le--;
                }
                int ri = mid;
                while (ri < nums.length && nums[ri] == target) {
                    ri++;
                }
                res[0] = le + 1;
                res[1] = ri - 1;
                break;
            }
            mid = left + (right - left) / 2;
        }
        return res;
    }

    public static void main(String[] args) {
        FirstAndLast fl = new FirstAndLast();
        int[] nums = {5,7,7,8,8,10};
        int[] res = fl.searchRange(nums, 6);
        System.out.println(Arrays.toString(res));
    }
}
