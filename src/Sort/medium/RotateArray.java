package Sort.medium;

public class RotateArray {
    /**
     * 搜索旋转排序数组
     * https://leetcode-cn.com/leetbook/read/top-interview-questions-medium/xvyz1t/
     */
    public int search(int[] nums, int target) {
        int rotate = nums.length - 1;
        int temp = nums[rotate];
        while (rotate > 0) {
            if (nums[rotate - 1] < temp) {
                rotate--;
            } else {
                break;
            }
        }
        //rotate为旋转点
        int res = help(nums, target, rotate, nums.length - 1);
        if (res == -1) {
            return help(nums, target, 0, rotate - 1);
        }
        return res;
    }

    public int help(int[] nums, int target, int low, int high) {
        if (low > high || target < nums[low] || target > nums[high]) {
            return -1;
        }
        int mid = low + (high - low) / 2;
        while (low <= high) {
            if (nums[mid] > target) {
                high = mid - 1;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                return mid;
            }
            mid = low + (high - low) / 2;
        }
        return -1;
    }

    public int search1(int[] nums, int target) {
        int result = -1;
        if (nums != null) {
            int left = 0, right = nums.length - 1;
            while (left <= right) {
                int middle = (left + right) / 2;
                if (nums[middle] == target) {
                    result = middle;
                    break;
                } else if (nums[left] <= nums[middle]) {
                    if (nums[left] <= target && target < nums[middle]) {
                        right = middle - 1;
                    } else {
                        left = middle + 1;
                    }
                } else {
                    if (target > nums[middle] && target <= nums[right]) {
                        left = middle + 1;
                    } else {
                        right = middle - 1;
                    }
                }
            }
        }
        return result;
    }


    public static void main(String[] args) {
        RotateArray ra = new RotateArray();
        int[] nums = {4, 5, 6, 7, 0, 1, 2, 3};
        int res = ra.search1(nums, 0);
        System.out.println(res);
    }

}
