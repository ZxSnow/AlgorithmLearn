package Tree.special;

import Tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Day1 {
    /**
     * 二叉树的遍历方式
     * 1.先序遍历：根——左节点——右节点
     * 2.中序遍历：左节点——根——右节点
     * 3.后序遍历：左节点——右节点——根
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        preTravel(root, result);

        return result;
    }

    public void preTravel(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }
        list.add(node.val);
        preTravel(node.left, list);
        preTravel(node.right, list);
    }

    public static void main(String[] args) {
        Day1 test = new Day1();
    }
}
