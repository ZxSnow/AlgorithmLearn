package Tree.medium;

import Tree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class SawtoothTravel {
    /**
     * 锯齿形遍历
     * 给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
     * https://leetcode-cn.com/leetbook/read/top-interview-questions-medium/xvle7s/
     * 广度优先搜索的方式
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> ro = new ArrayList<>();
        ro.add(root.val);
        res.add(ro);
        stack.add(root.left);
        stack.add(root.right);
        boolean flag = true;
        while (stack.size() > 0) {
            List<Integer> values = new ArrayList<>();
            Stack<TreeNode> travel = new Stack<>();

            while (stack.size() > 0) {
                TreeNode node = stack.pop();
                if (node != null) {
                    values.add(node.val);
                    if (flag) {
                        travel.add(node.right);
                        travel.add(node.left);
                    } else {
                        travel.add(node.left);
                        travel.add(node.right);
                    }
                }
            }
            flag = !flag;
            stack = travel;
            if (values.size() > 0) {
                res.add(values);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(2);
        root.right = new TreeNode(4);
        root.left.left = new TreeNode(1);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(-1);
        root.left.left.left = new TreeNode(5);
        root.left.left.right = new TreeNode(1);
        root.right.left.right = new TreeNode(6);
        root.right.right.right = new TreeNode(8);
        SawtoothTravel st = new SawtoothTravel();
        List<List<Integer>> res = st.zigzagLevelOrder(root);
        System.out.println(res);
    }
}
