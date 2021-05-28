package HotTop100;

import List.ListNode;

public class ReverseKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode tmp = head;
        for (int i = 0; i < k - 1; i++) {
            if (tmp == null || tmp.next == null) {
                return head;
            }
            tmp = tmp.next;
        }
        if (head == null) {
            return head;
        }

        ListNode last = reverseKGroup(tmp.next, k);
        tmp.next = null;
        return reverse(head, last);
    }

    public ListNode reverse(ListNode head, ListNode last) {
        if (head == null || head.next == null) {
            if (head != null) {
                head.next = last;
            }
            return head;
        }
        ListNode prev = last;
        ListNode next = null;
        while (head.next != null) {
            next = head.next;   //保存下一个节点
            head.next = prev;   //重置next
            prev = head;    //保存当前节点
            head = next;
        }
        head.next = prev;
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ReverseKGroup rp = new ReverseKGroup();
//        ListNode node = rp.reverseKGroup(head, 2);
//        System.out.println(node);

        System.out.println(rp.reverse(head, null));
    }
}
