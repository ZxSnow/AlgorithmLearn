package Sort.primary;

import java.util.Arrays;

public class Practice1 {
    /**
     * 排序与搜索
     * 1. 合并两个有序数组
     * 题目：给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
     * https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xnumcr/
     */
    public static void main(String[] args) {
        int[] nums1 = {0, 0, 3, 0, 0, 0, 0, 0, 0};
        int[] nums2 = {-1, 1, 1, 1, 2, 3};
        Practice1 p = new Practice1();
        p.merge(nums1, 3, nums2, 6);
        System.out.println(nums1);
    }

    public void merge1(int[] nums1, int m, int[] nums2, int n) {
        if (n >= 0) {
            System.arraycopy(nums2, 0, nums1, m, n);
        }
        Arrays.sort(nums1);
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int len1 = m - 1;
        int len2 = n - 1;
        int idx = nums1.length - 1;
        while (len1 >= 0 && len2 >= 0) {
            if (nums2[len2] >= nums1[len1]) {
                nums1[idx] = nums2[len2];
                len2--;
            } else {
                nums1[idx] = nums1[len1];
                len1--;
            }
            idx--;
            //简化写法
            //nums1[idx--] = nums1[len1] > nums2[len2] ? nums1[len1--] : nums2[len2--];

        }
        System.arraycopy(nums2, 0, nums1, 0, len2 + 1);
    }
}
