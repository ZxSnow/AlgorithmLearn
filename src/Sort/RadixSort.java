package Sort;

import java.util.Arrays;

public class RadixSort {
    public void radixSort(int[] nums) {
        int maxDigit = getMax(nums);
        for (int i = 1; maxDigit / i > 0; i *= 10) {
            int[][] buckets = new int[nums.length][10];

            for (int j = 0; j < nums.length; j++) {
                int num = (nums[j] / i) % 10;
                buckets[j][num] = nums[j];
            }
            //对元素进行回收
            int k = 0;
            for (int j = 0; j < 10; j++) {
                for (int l = 0; l < nums.length; l++) {
                    if (buckets[l][j] != 0) {
                        nums[k++] = buckets[l][j];
                    }
                }
            }
        }
    }

    public int getMaxDigit(int[] nums) {
        int max = 0;
        for (int i : nums) {
            int cnt = 0;
            while (i > 0) {
                cnt++;
                i /= 10;
            }
            max = Math.max(max, cnt);
        }
        return max;
    }

    public int getMax(int[] nums) {
        int max = nums[0];
        for (int num : nums) {
            max = Math.max(max, num);
        }
        return max;
    }

    public static void main(String[] args) {
        RadixSort rs = new RadixSort();
        int[] nums = {5, 36, 20, 3, 27, 46, 125};
        rs.radixSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
