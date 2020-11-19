package Sort;

public class InsertSort {
    public void insertSort(int[] nums) {
        int len = nums.length;
        int preIdx, cur;
        for (int i = 1; i < len; i++) {
            preIdx = i - 1;
            cur = nums[i];
            while (preIdx >= 0 && nums[preIdx] > cur) {
                nums[preIdx + 1] = nums[preIdx];
                preIdx--;
            }
            nums[preIdx + 1] = cur;
        }
    }
}
