package Array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Practice4 {
    /**
     * 题目：存在重复
     * 给定一个整数数组，判断是否存在重复元素。
     * 如果任何值在数组中出现至少两次，函数返回 true。如果数组中每个元素都不相同，则返回 false。
     * <p>
     * 题目地址：
     * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/1/array/24/
     */

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(containsDuplicate(nums));
        System.out.println(contains(nums));
    }

    public static boolean containsDuplicate(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            if (map.containsKey(i)) {
                return true;
            }
            map.put(i, i);
        }
        return false;
    }

    /**
     * 先排序，后比较
     *
     * @param nums
     * @return
     */
    public static boolean contains(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                return true;
            }
        }
        return false;
    }
}
