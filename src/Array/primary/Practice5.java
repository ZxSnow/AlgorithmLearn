package Array.primary;

import java.util.Arrays;

public class Practice5 {
    /**
     * 题目：只出现一次的数字
     * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
     * 说明：
     * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
     * 题目地址：
     * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/1/array/25/
     */
    public static void main(String[] args) {
        int[] nums = {4, 1, 2, 2, 1};
//        System.out.println(singleNumber(nums));
        System.out.println(singleNumber1(nums));
    }

    /**
     * 先排序，后比较
     *
     * @param nums
     * @return
     */
    public static int singleNumber(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i = i + 2) {
            if (i + 1 >= nums.length) {
                return nums[i];
            }
            if (i == nums.length - 1 || nums[i] != nums[i + 1]) {
                return nums[i];
            }
        }
        return -1;
    }

    /**
     * 异或运算
     *
     * @param nums
     * @return
     */
    public static int singleNumber1(int[] nums) {
        int result = 0;
        for (int i : nums) {
            result = result ^ i;
        }
        return result;
    }
}
