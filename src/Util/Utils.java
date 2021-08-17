package Util;

public class Utils {
    public static void swap(int[] nums, int i, int j) {
        if (i == j) return;

        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void swap(Integer[] nums, int i, int j) {
        if (i == j) return;

        Integer tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
