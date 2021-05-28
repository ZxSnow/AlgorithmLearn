package List.total;

import List.ListNode;

public class MergeTwoLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(0);
        int value1 = l1 == null ? Integer.MAX_VALUE : l1.val;
        int value2 = l2 == null ? Integer.MAX_VALUE : l2.val;
        res.next = value1 <= value2 ? l1 : l2;

        ListNode tmp;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                while (l1.next != null && l1.next.val <= l2.val) {
                    l1 = l1.next;
                }
                tmp = l1.next;
                l1.next = l2;
                l1 = tmp;
            } else {
                while (l2.next != null && l2.next.val <= l1.val) {
                    l2 = l2.next;
                }
                tmp = l2.next;
                l2.next = l1;
                l2 = tmp;
            }
        }
        return res.next;
    }

    /**
     * 递归
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        if (l1.val < l2.val) {
            return mergeTwoLists1(l1.next, l2);
        } else {
            return mergeTwoLists1(l2, l2.next);
        }
    }

    public static void main(String[] args) {
        MergeTwoLists mt = new MergeTwoLists();
        ListNode l1 = new ListNode(-9);
        l1.next = new ListNode(3);
//        l1.next.next = new ListNode(4);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(7);
//        l2.next.next = new ListNode(4);
        ListNode res = mt.mergeTwoLists(l1, l2);
        System.out.println(res);
    }
}
