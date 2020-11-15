package Sort.medium;

public class PeakElem {
    /**
     * 寻找峰值
     * https://leetcode-cn.com/leetbook/read/top-interview-questions-medium/xv4hjg/
     */

    public int findPeakElement(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                if (nums[i] > nums[i + 1]) {
                    return i;
                } else {
                    continue;
                }
            }
            if (i == nums.length - 1) {
                if (nums[i] > nums[i - 1]) {
                    return i;
                } else {
                    continue;
                }
            }
            if (nums[i] > nums[i - 1] && nums[i] > nums[i + 1]) {
                return i;
            }
        }
        return 0;
    }

    /**
     * 简化方法
     * @param nums
     * @return
     */
    public int findPeakElement1(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1])
                return i;
        }
        return nums.length - 1;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,2,1,6,3};
        PeakElem pe = new PeakElem();
        int res = pe.findPeakElement1(nums);
        System.out.println(res);
    }
}
