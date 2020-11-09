package Backtrack;

import java.util.ArrayList;
import java.util.List;

public class Permute {
    /**
     * 全排列
     * 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
     * https://leetcode-cn.com/leetbook/read/top-interview-questions-medium/xvqup5/
     */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        help(nums, path, res);
        return res;
    }

    public void help(int[] nums, List<Integer> path, List<List<Integer>> result) {
        if (nums.length == path.size()) {
            List<Integer> re = new ArrayList<>(path);
            result.add(re);
            return;
        }
        for (int num : nums) {
            if (path.contains(num)) {
                continue;
            }
            path.add(num);
            int idx = path.size();
            help(nums, path, result);

            path.remove(idx - 1);
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        Permute p = new Permute();
        List<List<Integer>> res = p.permute(arr);
        System.out.println(res);
    }
}
