package Tree.special;

import Tree.TreeNode;

import java.util.Arrays;

public class BuildTree {

    /**
     * 从中序与后序遍历序列构造二叉树
     *
     * @param inorder
     * @param postorder
     * @return
     */
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length == 0 || postorder == null) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[postorder.length - 1]);
        int idx = 0;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == root.val) {
                idx = i;
                break;
            }
        }
        int[] leftIn = Arrays.copyOfRange(inorder, 0, idx);
        int[] rightIn = Arrays.copyOfRange(inorder, idx + 1, inorder.length);

        int[] leftPost = Arrays.copyOfRange(postorder, 0, idx);
        int[] rightPost = Arrays.copyOfRange(postorder, idx, postorder.length - 1);

        TreeNode left = buildTree(leftIn, leftPost);
        TreeNode right = buildTree(rightIn, rightPost);
        root.left = left;
        root.right = right;
        return root;
    }

    /**
     * 从前序与中序遍历序列构造二叉树
     */
    public TreeNode buildTree2(int[] preorder, int[] inorder) {
        return help2(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    public TreeNode help2(int[] pre, int preBegin, int preEnd, int[] in, int inBegin, int inEnd) {
        if (preBegin == preEnd) {
            return new TreeNode(pre[preBegin]);
        }
        if (preBegin > preEnd) {
            return null;
        }

        TreeNode node = new TreeNode(pre[preBegin]);
        int idx = 0;
        for (int i = inBegin; i <= inEnd; i++) {
            if (in[i] == node.val) {
                idx = i;
                break;
            }
        }
        TreeNode left = help2(pre, preBegin + 1, idx - inBegin + preBegin, in, inBegin, idx - 1);
        TreeNode right = help2(pre, idx - inBegin + preBegin + 1, preEnd, in, idx + 1, inEnd);
        node.left = left;
        node.right = right;
        return node;
    }

    public static void main(String[] args) {
        int[] pre = {1, 2};
        int[] in = {2, 1};
        BuildTree bt = new BuildTree();
        TreeNode node = bt.buildTree2(pre, in);
        System.out.println(node);
    }

}
