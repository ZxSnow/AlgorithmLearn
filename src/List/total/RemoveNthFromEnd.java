package List.total;

import List.ListNode;

public class RemoveNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return null;
        }
        ListNode h = head;
        ListNode end = head;
        for (int i = 0; i < n; i++) {
            end = end.next;
        }
        //此时为当前所在元素要被删除
        if (end == null) {
            return h.next;
        }
        while (end.next != null) {
            h = h.next;
            end = end.next;
        }
        h.next = h.next.next;
        return head;
    }

    public static void main(String[] args) {
        RemoveNthFromEnd rn = new RemoveNthFromEnd();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        ListNode res = rn.removeNthFromEnd(head, 1);
        System.out.println(res);
    }
}
