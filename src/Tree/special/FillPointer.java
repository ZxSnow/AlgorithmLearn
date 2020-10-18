package Tree.special;

public class FillPointer {
    public Node connect(Node root) {
        help(root.left, root.right);
        return root;
    }

    public void help(Node left, Node right) {
        if (left == null||right==null) {
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
        fp.connect(no);
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
