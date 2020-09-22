package Tree;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(Integer x) {
        this.val = x;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    /**
     * 根据数组创建一棵树
     *
     * @param values
     * @return 根节点
     */
    public static TreeNode build(Integer[] values, int idx) {
        TreeNode root = null;
        if (idx < values.length) {
            root = new TreeNode(values[idx]);
            root.left = build(values, 2 * idx + 1);
            root.right = build(values, 2 * idx + 2);
        }
        return root;
    }


    public static void main(String[] args) {
        Integer[] test = {1, 2, 3, 4, 5};
        TreeNode node = TreeNode.build(test, 0);
        System.out.println(node);
    }
}
