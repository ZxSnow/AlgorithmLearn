package Array;

public class Practice1 {
    /**
     * 题目：从排序数组中删除重复项
     * <p>
     * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
     * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
     * 题目地址
     * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/1/array/21/
     *
     * 题解：
     * 要求空间复杂度为o(1),不能创建新的数组，在可以忽略新输出长度之后的数组
     * 考虑将新的数据放在已经比较过的数据位置上
     */

    public static void main(String[] args) {
        int nums[] = {1, 2, 2};
        int len = removeDuplicates(nums);
        for (int i = 0; i < len; i++) {
            System.out.print((nums[i]));
        }
    }

    public static int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int temp = 0;
        for (int i : nums) {
            if (i != nums[temp]) {
                temp++;
                nums[temp] = i;
            }
        }

        return temp + 1;
    }
}
