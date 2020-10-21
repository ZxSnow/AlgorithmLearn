package Tree.special;

import Tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FillPointer {
    public Node connect(Node root) {
        help(root.left, root.right);
        return root;
    }

    public void help(Node left, Node right) {
        if (left == null || right == null) {
            return;
        }
        left.next = right;
        help(left.left, left.right);
        help(left.right, right.left);
        help(right.left, right.right);
    }

    public static void main(String[] args) {
        FillPointer fp = new FillPointer();
        Node no = new Node(1);
        no.left = new Node(2);
        no.right = new Node(3);
        no.left.left = new Node(4);
        no.left.right = new Node(5);
        no.right.right = new Node(7);
//        no.left.left.left = new Node(7);
//        no.right.right.right = new Node(8);
        fp.connectV3(no);
    }

    /**
     * 用层级遍历的想法，超出了内存限制
     *
     * @param root
     */
    public Node connectV2(Node root) {
        if (root == null) return null;

        List<Node> nodes = new ArrayList<>();
        if (root.left != null) nodes.add(root.left);
        if (root.right != null) nodes.add(root.right);

        while (nodes.size() > 0) {
            List<Node> list = new ArrayList<>();
            for (int i = 0; i < nodes.size() - 1; i++) {
                Node before = nodes.get(i);
                Node next = nodes.get(i + 1);
                before.next = next;
                if (before.left != null) {
                    list.add(before.left);
                }
                if (before.right != null) {
                    list.add(before.right);
                }
                if (next.left != null) {
                    list.add(next.left);
                }
                if (next.right != null) {
                    list.add(next.right);
                }
            }
            nodes = list;
        }
        return root;
    }

    /**
     * 广度优先搜索（待完善） 超出限制
     *
     * @param root
     * @return
     */
    public Node connectV3(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root.left);
        queue.add(root.right);
        while (queue.size() > 1) {
            int size = queue.size();
            for (int i = 0; i < size - 1; i++) {
                Node before = queue.poll();
                Node next = queue.peek();
                before.next = next;
                if (before.left != null) {
                    queue.add(before.left);
                }
                if (before.right != null) {
                    queue.add(before.right);
                }
                if (next.left != null) {
                    queue.add(next.left);
                }
                if (next.right != null) {
                    queue.add(next.right);
                }
                if (i == size - 2) {
                    queue.poll();
                }
            }
        }
        return root;
    }

}

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
