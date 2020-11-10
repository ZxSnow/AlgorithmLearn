package Backtrack;

import java.util.ArrayList;
import java.util.List;

public class Subset {
    /**
     * 子集
     * 描述：给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
     * https://leetcode-cn.com/leetbook/read/top-interview-questions-medium/xv67o6/
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i <= nums.length; i++) {
            List<List<Integer>> list = new ArrayList<>();
            List<Integer> path = new ArrayList<>();
            cnt = i;
            help(nums, path, list, 0);
            res.addAll(list);
        }
        return res;
    }

    int cnt = 0;

    public void help(int[] choices, List<Integer> path, List<List<Integer>> list, int n) {
        if (path.size() == cnt) {
            List<Integer> res = new ArrayList<>(path);
            list.add(res);
            return;
        }
        for (int i = n; i < choices.length; i++) {
            if (path.contains(choices[i])) {
                continue;
            }
            path.add(choices[i]);
            int idx = path.size();
            help(choices, path, list, Math.max(i, n + 1));
            path.remove(idx - 1);
        }
    }

    public static void main(String[] args) {
        Subset s = new Subset();
        int[] nums = {1, 2};
        List<List<Integer>> res = s.subsets(nums);
        System.out.println(res);
    }
}
