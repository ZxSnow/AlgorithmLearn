package Inorder;

import java.util.ArrayList;
import java.util.List;

public class No229 {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if (nums == null || nums.length == 0)
            return res;

        int can1 = nums[0], vote1 = 0;
        int can2 = nums[0], vote2 = 0;

        for (int i : nums) {
            if (can1 == i) {
                vote1++;
            } else if (can2 == i) {
                vote2++;
            } else if (vote1 == 0) {
                can1 = i;
                vote1 = 1;
            } else if (vote2 == 0) {
                can2 = i;
                vote2 = 1;
            } else {
                vote1--;
                vote2--;
            }
        }
        int cnt1 = 0, cnt2 = 0;
        for (int i : nums) {
            if (i == can1)
                cnt1++;
            if (i == can2)
                cnt2++;
        }
        if (cnt1 > nums.length / 3)
            res.add(cnt1);
        if (cnt2 > nums.length / 3)
            res.add(cnt2);
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 3, 3, 2, 2, 2};

        No229 no = new No229();
        List<Integer> list = no.majorityElement(nums);
        System.out.println(list);
    }
}
