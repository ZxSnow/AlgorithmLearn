package HotTop100;

public class Search {
    public int search(int[] nums, int target) {
        int right = nums.length - 1;
        int left = 0;
        int mid = nums.length / 2;

        while (left <= right) {
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[left] > nums[mid]) {
                //找单调区间 mid --- right
                if (target > nums[mid] && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else {
                //找单调区间 left --- mid
                if (nums[mid] > target && target >= nums[left]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            mid = (right + left) / 2;
        }
        return -1;
    }

    public static void main(String[] args) {
        Search search = new Search();
        int[] nums = {1, 3, 5};
        System.out.println(search.search(nums, 5));
    }
}
