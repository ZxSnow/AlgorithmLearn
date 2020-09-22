package Tree;

import java.util.ArrayList;
import java.util.List;

public class Practice4 {
    /**
     * 二叉树的层序遍历
     * https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xnldjj/
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        List<TreeNode> list = new ArrayList<>();
        list.add(root);

        while (list.size() > 0) {
            List<Integer> layer = new ArrayList<>();
            List<TreeNode> loop = new ArrayList<>();
            for (TreeNode node : list) {
                layer.add(node.val);
                if (node.left != null) {
                    loop.add(node.left);
                }
                if (node.right != null) {
                    loop.add(node.right);
                }
            }
            result.add(layer);
            list = loop;
        }

        return result;
    }
}
