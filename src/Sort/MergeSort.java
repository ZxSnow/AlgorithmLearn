package Sort;

public class MergeSort {
    public void mergeSort(int[] nums, int low, int high) {
        int mid = (low + high) / 2;
        if (low < high) {
            mergeSort(nums, low, mid);
            mergeSort(nums, mid + 1, high);
            merge(nums, low, high, mid);
        }
    }

    public void merge(int[] nums, int low, int high, int mid) {
        int[] temp = new int[high - low + 1];
        int left = low;
        int right = mid + 1;
        int i;
        for (i = 0; left <= mid && right <= high; i++) {
            if (nums[left] < nums[right]) {
                temp[i] = nums[left++];
            } else {
                temp[i] = nums[right++];
            }
        }
        while (left <= mid) {
            temp[i++] = nums[left++];
        }
        while (right <= high) {
            temp[i++] = nums[right++];
        }
        if (temp.length >= 0) System.arraycopy(temp, 0, nums, low, temp.length);
    }

    public static void main(String[] args) {
        MergeSort ms = new MergeSort();
        int[] nums = {4, 3, 6, 2, 7, 1, 5, 8};
        ms.mergeSort(nums, 0, nums.length - 1);
    }
}
