package Sort;

import java.util.Arrays;

public class CountSort {
    public void countingSort(int[] nums) {
        int max = getMax(nums);
        int[] res = new int[nums.length];
        int[] count = new int[max + 1];
        System.arraycopy(nums, 0, res, 0, nums.length);
        for (int num : nums) {
            count[num]++;
        }
        for (int i = 1; i < count.length; i++) {
            count[i] = count[i] + count[i - 1];
        }
        for (int re : res) {
            nums[--count[re]] = re;
        }
    }

    public int getMax(int[] nums) {
        int max = nums[0];
        for (int num : nums) {
            max = Math.max(max, num);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr = {10, 5, 11, 68, 20, 41, 0, 24, 25, 4, 7, 94, 15, 5, 44, 66};
        CountSort cs = new CountSort();
        cs.countingSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
