package List.medium;

import List.ListNode;

public class IntersectList {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int aLen = length(headA);
        int bLen = length(headB);

        int gap = aLen - bLen;
        gap = gap > 0 ? gap : -gap;
        ListNode max = aLen > bLen ? headA : headB;
        ListNode min = aLen > bLen ? headB : headA;

        while (gap > 0) {
            max = max.next;
            gap--;
        }
        while (max != null && min != null) {
            if (max.equals(min)) {
                return max;
            }
            max = max.next;
            min = min.next;
        }
        return null;
    }

    public int length(ListNode node) {
        int res = 0;
        while (node != null) {
            res++;
            node = node.next;
        }
        return res;
    }

    /**
     * No. 160 相交链表
     * 解法：双指针，逻辑拼接
     *
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        ListNode a = headA, b = headB;
        while (a != b) {
            if (a == null) {
                a = headB;
            } else {
                a = a.next;
            }

            if (b == null) {
                b = headA;
            } else {
                b = b.next;
            }
        }
        return a;
    }

    public static void main(String[] args) {
        IntersectList il = new IntersectList();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);

        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(2);
        head2.next.next = new ListNode(3);
        ListNode res = il.getIntersectionNode2(head, head2);
        System.out.println(res);
    }
}
