package Tree;

public class Practice3 {
    /**
     * 对称二叉树验证
     * https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xn7ihv/
     *
     * @param root
     * @return
     */

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return help(root.left, root.right);
    }

    public boolean help(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) {
            return true;
        }
        if (node1 == null || node2 == null) {
            return false;
        }
        if (node1.val != node2.val) {
            return false;
        }
        return help(node1.left, node2.right) && help(node1.right, node2.left);
    }

}
