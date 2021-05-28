package List;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder(val + "->");
        ListNode next = this.next;
        while (next != null) {
            res.append(next.val).append("->");
            next = next.next;
        }
        return res.toString();
    }
}
