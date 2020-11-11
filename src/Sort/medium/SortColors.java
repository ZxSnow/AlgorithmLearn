package Sort.medium;

import java.util.Arrays;

public class SortColors {
    /**
     * 颜色分类
     * https://leetcode-cn.com/leetbook/read/top-interview-questions-medium/xvg25c/
     */
    public void sortColors(int[] nums) {
        int low = 0;
        int move = nums.length - 1;
        int high = nums.length - 1;
        while (low <= move) {
            while (low < nums.length - 1 && nums[low] == 0) {
                low++;
            }
            if (move >= low && nums[move] == 0) {
                nums[move] = nums[low];
                nums[low++] = 0;
            }
            if (move <= high && nums[move] == 2) {
                nums[move] = nums[high];
                nums[high--] = 2;
            }
            move--;
        }
    }

    public static void main(String[] args) {
        SortColors sc = new SortColors();
        int[] nums = {1, 0, 0};
        sc.sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }
}
