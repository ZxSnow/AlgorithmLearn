package HotTop100;

import java.util.Random;

public class FindKthLargest {

    Random rdm = new Random();

    public int findKthLargest(int[] nums, int k) {
        return quick(nums, 0, nums.length - 1, nums.length - k);
    }

    public int quick(int[] nums, int le, int ri, int idx) {
        int p = random(nums, le, ri);
        if (p == idx)
            return nums[p];
        if (p < idx)
            return quick(nums, p + 1, ri, idx);
        return quick(nums, le, p - 1, idx);
    }

    public int random(int[] nums, int le, int ri) {
        int i = rdm.nextInt(ri - le + 1) + le;
        swap(nums, le, i);
        return partition(nums, le, ri);
    }

    public int partition(int[] nums, int left, int right) {
        int pivot = nums[left];
        int cnt = left;
        for (int i = left + 1; i <= right; i++) {
            if (nums[i] < pivot)
                swap(nums, ++cnt, i);
        }
        swap(nums, cnt, left);
        return cnt;
    }

    public void swap(int[] nums, int i, int j) {
        if (i == j) return;
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

}
