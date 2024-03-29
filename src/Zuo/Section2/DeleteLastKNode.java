package Zuo.Section2;

import List.ListNode;

public class DeleteLastKNode {
    public ListNode removeLastKthNode(ListNode head, int k) {
        if (head == null || k < 1)
            return head;
        ListNode cur = head;
        while (cur != null) {
            k--;
            cur = cur.next;
        }
        if (k == 0) {
            head = head.next;
        }
        if (k < 0) {
            cur = head;
            while (++k != 0) {
                cur = cur.next;
            }
            cur.next = cur.next.next;
        }
        return head;
    }
}
