package Array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Practice9 {
    /**
     * 题目：两数之和
     * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
     * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
     * <p>
     * 示例:
     * 给定 nums = [2, 7, 11, 15], target = 9
     * 因为 nums[0] + nums[1] = 2 + 7 = 9
     * 所以返回 [0, 1]
     * <p>
     * 题目地址：
     * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/1/array/29/
     */
    public static void main(String[] args) {
        int[] nums = {-1, -2, -3, -4, -5};
        int[] result = twoSum(nums, -8);
        int[] result2 = twoSum1(nums, -8);
        for (int i : result) {
            System.out.print(i + " ");
        }
    }

    public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                result[0] = map.get(nums[i]);
                result[1] = i;
                break;
            }
            map.put(target - nums[i], i);
        }
        return result;
    }

    /**
     * 没看懂...
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum1(int[] nums, int target) {
        int max = 2047;
        int[] res = new int[max + 1];

        for (int i = 0; i < nums.length; i++) {
            int ldiff = (target - nums[i]) & max;
            if (res[ldiff] != 0) {
                return new int[]{res[ldiff] - 1, i};
            }
            res[nums[i] & max] = i + 1;
        }
        return new int[2];
    }
}
