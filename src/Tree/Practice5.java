package Tree;

import java.util.TreeMap;

public class Practice5 {

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) {
            return new TreeNode();
        }
        return help(nums, 0, nums.length - 1);
    }

    public TreeNode help(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }
        if (start == end) {
            return new TreeNode(nums[start]);
        }
        int mid;
        if ((end - start) % 2 == 0) {
            mid = start + (end - start) / 2;
        } else {
            mid = start + (end - start) / 2 + 1;
        }
        TreeNode root = new TreeNode();
        root.val = nums[mid];
        root.left = help(nums, start, mid - 1);
        root.right = help(nums, mid + 1, end);
        return root;
    }

    public static void main(String[] args) {
        int[] test = {-10, -3, 0, 5, 9};
        Practice5 t = new Practice5();
        t.sortedArrayToBST(test);
    }

}
