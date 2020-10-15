package Tree.special;

import Tree.TreeNode;

import java.util.*;

public class Traverse {
    /**
     * 二叉树的遍历
     * 前序遍历：https://leetcode-cn.com/leetbook/read/data-structure-binary-tree/xeywh5/
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        preorderHelp(root, list);
        return list;
    }

    public void preorderHelp(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }
        list.add(node.val);
        preorderHelp(node.left, list);
        preorderHelp(node.right, list);
    }

    /**
     * 中序遍历
     *
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inorderHelp(root, list);
        return list;
    }

    public void inorderHelp(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }
        inorderHelp(node.left, list);
        list.add(node.val);
        inorderHelp(node.right, list);
    }

    /**
     * 后续遍历
     *
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        postOrderHelp(root, list);
        return list;
    }

    public void postOrderHelp(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }
        postOrderHelp(node.left, list);
        postOrderHelp(node.right, list);
        list.add(node.val);
    }

    /**
     * 层序遍历，Tree.Practice4实现了一个层序遍历方式，但不是严格的BFS方式
     * BFS方法：核心使用数据结构Queue
     * 在循环内部，让所有节点齐头并进
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return new ArrayList();
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                if (cur != null) {
                    list.add(cur.val);
                    queue.add(cur.left);
                    queue.add(cur.right);
                }
            }
            if (list.size() > 0)
                result.add(list);
        }
        return result;
    }

    public static void main(String[] args) {
        Traverse t = new Traverse();
        TreeNode node = new TreeNode(3);
        node.left = new TreeNode(9);
        node.right = new TreeNode(20);
        node.right.left = new TreeNode(15);
        node.right.right = new TreeNode(7);
        List<List<Integer>> res = t.levelOrder(node);
        System.out.println(res);
    }
}
