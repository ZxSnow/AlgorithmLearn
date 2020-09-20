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

        if (root == null) {
            return true;
        }
        if (root.left != null && root.val <= root.left.val) {
            return false;
        }
        if (root.right != null && root.val >= root.right.val) {
            return false;
        }

        if (!isValidBST(root.left) || !isValidBST(root.right)) {
            return false;
        }
        return true;
    }
}
