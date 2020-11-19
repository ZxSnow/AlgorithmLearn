package Sort;

public class SelectSort {
    public void selectSort(int[] nums) {
        int len = nums.length;
        int minIdx;
        for (int i = 0; i < len - 1; i++) {
            minIdx = i;
            for (int j = i + 1; j < len; j++) {
                if (nums[j] < nums[minIdx]) {
                    minIdx = j;
                }
            }
            int temp = nums[i];
            nums[i] = nums[minIdx];
            nums[minIdx] = temp;
        }
    }
}
