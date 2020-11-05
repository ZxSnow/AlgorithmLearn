package Tree.primary;

import Tree.TreeNode;

public class Practice2 {
    /**
     * https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xn08xg/
     */

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(1);
        Practice2 p = new Practice2();
        p.isValidBST(root);
    }

    public boolean isValidBST(TreeNode root) {
        return help(root, null, null);
    }

    public boolean help(TreeNode root, TreeNode max, TreeNode min) {
        if (root == null) {
            return true;
        }
        if (max != null && root.val >= max.val) {
            return false;
        }
        if (min != null && root.val <= min.val) {
            return false;
        }

        return help(root.left, root, min) && help(root.right, max, root);
    }
}
