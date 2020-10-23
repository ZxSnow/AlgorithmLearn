package Tree.special;

import Tree.TreeNode;

public class NearForeFather {
    /**
     * https://leetcode-cn.com/leetbook/read/data-structure-binary-tree/xopaih/
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        if (root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) {
            return root;
        }
        if (left == null && right == null) {
            return null;
        }
        return left == null ? right : left;
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(3);
        node.left = new TreeNode(5);
        node.right = new TreeNode(1);
        node.left.left = new TreeNode(6);
        node.left.right = new TreeNode(2);
        node.right.left = new TreeNode(0);
        node.right.right = new TreeNode(8);
        node.left.right.left = new TreeNode(7);
        node.left.right.right = new TreeNode(4);
        NearForeFather nf = new NearForeFather();
        nf.lowestCommonAncestor(node, node.left.left, node.left.right.right);
    }
}
