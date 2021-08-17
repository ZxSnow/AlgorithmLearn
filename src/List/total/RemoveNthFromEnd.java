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

    public ListNode removeNthFromEnd1(ListNode head, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        //得到要删除节点的前一个节点
        ListNode delete = findFromEnd(dummy, n + 1);
        delete.next = delete.next.next;
        return dummy.next;
    }

    ListNode findFromEnd(ListNode head, int k) {
        ListNode p1 = head;
        // p1 先走 k 步
        for (int i = 0; i < k; i++) {
            p1 = p1.next;
        }
        ListNode p2 = head;
        // p1 和 p2 同时走 n - k 步
        while (p1 != null) {
            p2 = p2.next;
            p1 = p1.next;
        }
        // p2 现在指向第 n - k 个节点
        return p2;
    }

    public static void main(String[] args) {
        RemoveNthFromEnd rn = new RemoveNthFromEnd();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        ListNode res = rn.removeNthFromEnd(head, 1);
        System.out.println(res);
    }
}
