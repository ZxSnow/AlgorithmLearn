package Tree;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {
    }

    public TreeNode(Integer x) {
        this.val = x;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    /**
     * 序列化
     * https://leetcode-cn.com/leetbook/read/data-structure-binary-tree/xomr73/
     *
     * @param root
     * @return
     */
    public String serialize(TreeNode root) {

        return null;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {

        return null;
    }


    public static void main(String[] args) {
        Integer[] test = {1, 2, 3, 4, 5};
    }
}
