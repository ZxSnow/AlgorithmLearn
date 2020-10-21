package Tree.special;

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
        fp.connectV0(no);
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
     * 广度优先搜索
     *
     * @param root
     * @return
     */
    public Node connectV3(Node root) {
        if (root == null) return null;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root.left);
        queue.add(root.right);
        while (!queue.isEmpty()) {
            int size = queue.size();
            Node pre = null;
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                if (node == null) continue;
                if (pre != null) {
                    pre.next = node;
                }
                pre = node;
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }
        return root;
    }

    /**
     * 使用了两个链表同时推进两个层的节点，cur表示较高一层的节点列表，pre表示较低一层，
     * pre前进的条件是cur有非空的子节点，推进的同时对接点进行相连，在一开始创建的dummy指向了pre这一行的最左侧
     *
     * @param root
     * @return
     */
    public Node connectV0(Node root) {
        if (root == null)
            return root;
        //cur我们可以把它看做是每一层的链表
        Node cur = root;
        while (cur != null) {
            //遍历当前层的时候，为了方便操作在下一
            //层前面添加一个哑结点（注意这里是访问
            //当前层的节点，然后把下一层的节点串起来）
            Node dummy = new Node(0);
            //pre表示访下一层节点的前一个节点
            Node pre = dummy;
            //然后开始遍历当前层的链表
            while (cur != null) {
                if (cur.left != null) {
                    //如果当前节点的左子节点不为空，就让pre节点
                    //的next指向他，也就是把它串起来
                    //此时dummy的next也变成了左节点
                    pre.next = cur.left;
                    //然后再更新pre
                    pre = pre.next;
                }
                //同理参照左子树
                if (cur.right != null) {
                    pre.next = cur.right;
                    pre = pre.next;
                }
                //继续访问这一行的下一个节点
                cur = cur.next;
            }
            //把下一层串联成一个链表之后，让他赋值给cur，
            //后续继续循环，直到cur为空为止
            cur = dummy.next;
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
