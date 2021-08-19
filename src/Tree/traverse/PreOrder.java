package Tree.traverse;

import Tree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PreOrder {

    public List<Integer> preOrderUnRecur(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null)
            return res;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            res.add(cur.val);
            if (cur.right != null) {
                stack.add(cur.right);
            }
            if (cur.left != null) {
                stack.add(cur.left);
            }
        }
        return res;
    }
}
