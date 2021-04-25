package HotTop100;

import java.util.*;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            List<List<Integer>> list = twoSum(nums, i + 1, -nums[i]);
            for (List<Integer> li : list) {
                li.add(nums[i]);
            }
            if (list.size() > 0) {
                res.addAll(list);
            }
        }
        return res;
    }

    public List<List<Integer>> twoSum(int[] nums, int start, int target) {
        List<List<Integer>> res = new ArrayList<>();
        int s = start;
        int end = nums.length - 1;
        while (s < end) {
            int sum = nums[s] + nums[end];
            int left = nums[s];
            int right = nums[end];
            if (sum < target) {
                while (s < end && nums[s] == left)
                    s++;
            } else if (sum > target) {
                while (s < end && nums[end] == right)
                    end--;
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(left);
                list.add(right);
                res.add(list);
                while (s < end && nums[s] == left) s++;
                while (s < end && nums[end] == right) end--;
            }
        }
        return res;
    }

    public int threeSumClosest(int[] nums, int target) {
        int dis = Integer.MAX_VALUE;
        Arrays.sort(nums);
        int result = 0;

        for (int i = 0; i < nums.length - 2; i++) {
            //三数之和
            int sum = help(nums, i + 1, target - nums[i]) + nums[i];

            int tmp = target - sum;
            if (dis > Math.abs(tmp)) {
                dis = Math.abs(tmp);
                result = sum;
            }
        }
        return result;
    }

    /**
     * 返回最接近target的两数之和
     *
     * @param nums
     * @param start
     * @param target
     * @return
     */
    public int help(int[] nums, int start, int target) {
        int res = Integer.MAX_VALUE;
        int left = start;
        int right = nums.length - 1;
        int copy = Integer.MIN_VALUE;

        while (left < right) {
            int tmp = target - (nums[left] + nums[right]);
            if (res > Math.abs(tmp)) {
                copy = nums[left] + nums[right];
                res = Math.abs(tmp);
            }
            if (tmp > 0) {
                left++;
            } else {
                right--;
            }
        }
        return copy;
    }

    public static void main(String[] args) {
        int[] nums = {-1,2,1,-4};
        ThreeSum ts = new ThreeSum();
//        List<List<Integer>> res = ts.threeSum(nums);
//        System.out.println(res);
        int res = ts.threeSumClosest(nums, 1);
        System.out.println(res);
    }
}
