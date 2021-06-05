package List.medium;

import List.ListNode;

public class ReverseBetween {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null) {
            return null;
        }
        int cnt = 1;

        ListNode pre = new ListNode(0);
        pre.next = head;
        ListNode res = pre;
        while (pre != null && cnt < left) {
            pre = pre.next;
            cnt++;
        }
        ListNode after = pre;
        while (after != null && cnt <= right) {
            after = after.next;
            cnt++;
        }
        ListNode tmp = after.next;
        after.next = null;
        pre.next = reverse2(pre.next, tmp);
        return res.next;
    }

    public ListNode reverse2(ListNode head, ListNode after) {
        if (head == null) {
            return null;
        }
        ListNode pre = after;
        ListNode next;

        while (head.next != null) {
            next = head.next;

            head.next = pre;
            pre = head;

            head = next;
        }
        head.next = pre;
        return head;
    }

    public static void main(String[] args) {
        ReverseBetween rb = new ReverseBetween();

        int[] nums = {1, 2, 3, 4, 5};
        ListNode node = ListNode.arrayToListNode(nums);
        System.out.println(node);

        ListNode res = rb.reverseBetween(node, 1, 1);
        System.out.println(res);
    }
}
