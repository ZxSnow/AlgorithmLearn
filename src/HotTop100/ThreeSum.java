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

    public static void main(String[] args) {
        int[] nums = {0, 0, 0, 0};
        ThreeSum ts = new ThreeSum();
        List<List<Integer>> res = ts.threeSum(nums);
        System.out.println(res);
    }
}
