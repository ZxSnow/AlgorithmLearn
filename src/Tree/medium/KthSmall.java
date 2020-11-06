package Tree.medium;

import Tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class KthSmall {
    /**
     * 二叉搜索树中第K小的元素
     * https://leetcode-cn.com/leetbook/read/top-interview-questions-medium/xvuyv3/
     *
     * @param root
     * @param k
     * @return
     */

    public int kthSmallest(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        get(root, list);
        return list.get(list.size() - k);
    }

    public void get(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        get(root.right, list);
        list.add(root.val);
        get(root.left, list);
    }

    public static void main(String[] args) {
        KthSmall ks = new KthSmall();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.left.right = new TreeNode(2);
        int res = ks.kthSmallest(root, 1);
        System.out.println(res);
    }
}
