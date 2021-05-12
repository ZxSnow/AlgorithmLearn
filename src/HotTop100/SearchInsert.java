package HotTop100;

public class SearchInsert {
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int mid = nums.length / 2;
        while (left <= right) {
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                return mid;
            }
            mid = left + (right - left) / 2;
        }
        System.out.println(left == right + 1);
        return right + 1;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 6};

        SearchInsert si = new SearchInsert();
        int res = si.searchInsert(nums, 0);
        System.out.println(res);
    }
}
