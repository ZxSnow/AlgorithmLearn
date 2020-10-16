package Array.primary;

public class Practice3 {
    /**
     * 题目：旋转数组
     * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
     * 题目：
     * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/1/array/23/
     */
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
//        int[] result = rotate0(nums, 2);
        int[] result = rotate1(nums, 1);
        for (int i : result) {
            System.out.print(i + " ");
        }
    }

    /**
     * 备份数组的方法
     *
     * @param nums
     * @param k
     * @return
     */
    private static int[] rotate0(int[] nums, int k) {
        if (k >= nums.length) {
            k = k % nums.length;
        }
        int[] arr = new int[k];
        int j = 0;
        for (int i = nums.length - k; i <= nums.length - 1; i++) {
            arr[j] = nums[i];
            j++;
        }
        for (int i = nums.length - 1 - k; i >= 0; i--) {
            nums[i + k] = nums[i];
        }
        for (int i = 0; i < k; i++) {
            nums[i] = arr[i];
        }
        return nums;
    }

    /**
     * 数组翻转
     *
     * @param nums
     * @param k
     * @return
     */
    private static int[] rotate1(int[] nums, int k) {
        k = k % nums.length;

        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
        return nums;
    }

    private static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int tempS = nums[start];
            int tempE = nums[end];
            nums[end] = tempS;
            nums[start] = tempE;
            start++;
            end--;
        }
    }
}
