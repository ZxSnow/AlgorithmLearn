package Array.primary;

public class Practice8 {
    /**
     * 题目：移动0
     * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
     * <p>
     * 示例:
     * 输入: [0,1,0,3,12]
     * 输出: [1,3,12,0,0]
     * <p>
     * 说明:
     * 必须在原数组上操作，不能拷贝额外的数组。
     * 尽量减少操作次数。
     * <p>
     * 题目地址：
     * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/1/array/28/
     */
    public static void main(String[] args) {
        int[] nums = {0,1,0,3,12};
        moveZeroes(nums);
        for (int i : nums) {
            System.out.print(i + " ");
        }
    }

    public static void moveZeroes(int[] nums) {
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != 0) {
                nums[i] = nums[j];
                if (j != i) {
                    nums[j] = 0;
                }
                i++;
            }
        }
    }
}
