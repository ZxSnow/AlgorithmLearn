package Tree.primary;

import Tree.TreeNode;

public class Practice1 {
    /**
     * 二叉树的最大深度
     * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/7/trees/47/
     */
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.left.left = null;
        root.left.right = null;

        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        System.out.println("深度：" + maxDepth(root));
    }

    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = maxDepth(root.left) + 1;
        int right = maxDepth(root.right) + 1;
        return Math.max(left, right);
    }
}
