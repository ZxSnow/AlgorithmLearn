package Inorder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class No47 {
    /**
     * 全排列II
     * 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        back(new ArrayList<>(), nums, new int[nums.length]);
        return res;
    }

    List<List<Integer>> res = new ArrayList<>();

    public void back(List<Integer> path, int[] nums, int[] used) {
        if (path.size() == nums.length) {
            List<Integer> list = new ArrayList<>(path);
            res.add(list);
            return;
        }

        int last = -11;

        for (int i = 0; i < nums.length; i++) {
            if (used[i] == 1 || last == nums[i]) {
                continue;
            }
            path.add(nums[i]);
            used[i] = 1;
            int len = path.size() - 1;

            back(path, nums, used);

            last = path.remove(len);
            used[i] = 0;
        }
    }

    public static void main(String[] args) {
        No47 no = new No47();
        int[] nums = {3, 3, 0, 3};
        List<List<Integer>> res = no.permuteUnique(nums);
        System.out.println(res);
    }
}
