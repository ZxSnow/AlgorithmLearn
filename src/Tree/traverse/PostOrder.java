package Tree.traverse;

import Tree.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class PostOrder {
    /**
     * 后续遍历：left - right - root
     * 与 root - right - left（这种方式可以使用类似迭代先序遍历的方式实现）是一个互逆过程
     *
     * @return
     */
    public List<Integer> postOrderReverse(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null)
            return res;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            res.add(cur.val);

            if (cur.left != null) {
                stack.push(cur.left);
            }
            if (cur.right != null) {
                stack.push(cur.right);
            }
        }

        Collections.reverse(res);
        return res;
    }

    public List<Integer> postOrderUnRecur(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null)
            return res;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        TreeNode cur;
        while (!stack.isEmpty()) {
            cur = stack.peek();
            if (cur.left != null && root != cur.left && root != cur.right)
                stack.push(cur.left);
            else if (cur.right != null && root != cur.right)
                stack.push(cur.right);
            else {
                res.add(stack.pop().val);
                root = cur;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        PostOrder post = new PostOrder();

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        List<Integer> res = post.postOrderUnRecur(root);
        System.out.println(res);
    }
}
