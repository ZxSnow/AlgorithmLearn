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

    /**
     * 深度优先搜索，Leetcode上通过案例 0ms
     * 思路：每下降一个深度，就创建一个新的list，受所处层影响，只有当前层的节点值才会被添加进来
     * 如果当前层为奇数层，在val值添加的时候，添加到最前面（idx=0的位置），此时所有元素都在向后移动
     * 如果是偶数层，就在列表结尾添加值
     *
     * @param root
     * @return
     */
    public List<List<Integer>> zigzagLevelOrder1(TreeNode root) {
        List<List<Integer>> arr = new ArrayList<List<Integer>>();
        zigzagPreOrder(arr, root, 0);
        return arr;
    }

    public void zigzagPreOrder(List<List<Integer>> arr, TreeNode root, int level) {
        if (root == null) return;
        if (level >= arr.size()) {
            arr.add(new ArrayList<Integer>());
        }


        if (level % 2 != 0) {
            arr.get(level).add(0, root.val);
        } else {
            arr.get(level).add(root.val);
        }
        zigzagPreOrder(arr, root.left, level + 1);
        zigzagPreOrder(arr, root.right, level + 1);
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
        List<List<Integer>> res = st.zigzagLevelOrder1(root);
        System.out.println(res);
    }
}
