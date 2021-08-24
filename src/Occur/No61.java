package Occur;

import List.ListNode;

public class No61 {
    public ListNode rotateRight(ListNode head, int k) {
        if (k == 0 || head == null || head.next == null) {
            return head;
        }
        int n = 1;
        ListNode node = head;
        while (node.next != null) {
            node = node.next;
            n++;
        }
        int step = n - k % n;

        node.next = head;
        while (step-- > 0) {
            node = node.next;
        }
        ListNode res = node.next;
        node.next = null;
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        ListNode node = ListNode.arrayToListNode(nums);
        No61 no = new No61();
        ListNode res = no.rotateRight(node, 2);
        System.out.println(res);
    }
}
