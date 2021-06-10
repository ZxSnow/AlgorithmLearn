package HotTop100;

import java.util.Arrays;

public class NextPermutation {
    public void nextPermutation(int[] nums) {
        int len = nums.length;
        if (nums.length <= 1) {
            return;
        }
        int i = len - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }

        if (i >= 0) {
            int k = len - 1;
            while (nums[i] >= nums[k]) {
                k--;
            }
            swap(nums, i, k);
        }
        reverse(nums, i + 1, len - 1);
    }

    public void reverse(int[] nums, int begin, int end) {
        while (begin < end) {
            swap(nums, begin, end);
            begin++;
            end--;
        }
    }

    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        NextPermutation np = new NextPermutation();
        int[] nums = {3,2,1};
        np.nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }
}
