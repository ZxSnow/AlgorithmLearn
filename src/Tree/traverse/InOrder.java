package Tree.traverse;

import Tree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InOrder {
    public List<Integer> inOrderUnRecur(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null)
            return res;

        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            if (!stack.isEmpty()) {
                root = stack.pop();
                res.add(root.val);
                root = root.right;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        InOrder in = new InOrder();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        List<Integer> res = in.inOrderUnRecur(root);
        System.out.println(res);
    }
}
