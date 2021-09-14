package Inorder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class No239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        MonotonicQueue win = new MonotonicQueue();
        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            if (i < k - 1) {
                win.push(nums[i]);
            } else {
                win.push(nums[i]);

                res.add(win.max());

                win.pop(nums[i - k + 1]);
            }
        }
        int[] re = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            re[i] = res.get(i);
        }
        return re;
    }

    public static void main(String[] args) {
        No239 no = new No239();
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int[] res = no.maxSlidingWindow(nums, 3);
        System.out.println(Arrays.toString(res));
    }
}

class MonotonicQueue {
    LinkedList<Integer> q = new LinkedList<>();

    public void push(int n) {
        while (!q.isEmpty() && q.getLast() < n) {
            q.pollLast();
        }
        q.addLast(n);
    }

    public int max() {
        return q.getFirst();
    }

    public void pop(int n) {
        if (n == q.getFirst()) {
            q.pollFirst();
        }
    }
}
