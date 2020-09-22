package Tree;

public class Practice2 {
    /**
     * https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xn08xg/
     */

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
//        root.left;
    }

    public boolean isValidBST(TreeNode root) {
        return help(root, null, null);
    }

    public boolean help(TreeNode root, TreeNode max, TreeNode min) {
        if (root == null) {
            return true;
        }

        return help(root.left, root, min) && help(root.right, max, root);
    }
}
