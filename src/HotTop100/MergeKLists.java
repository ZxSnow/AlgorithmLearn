package HotTop100;

import List.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKLists {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        ListNode res = lists[0];

        for (int i = 1; i < lists.length; i++) {
            res = mergeTwoLists(lists[i], res);
        }
        return res;
    }

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


    public static void main(String[] args) {
//        [1,4,5],[1,3,4],[2,6]
        ListNode node1 = new ListNode(1);
        node1.next = new ListNode(4);
        node1.next.next = new ListNode(5);
        System.out.println(node1.toString());

        ListNode node2 = new ListNode(1);
        node2.next = new ListNode(3);
        node2.next.next = new ListNode(4);

        ListNode node3 = new ListNode(2);
        node3.next = new ListNode(6);

        ListNode[] lists = {node1, node2, node3};

        MergeKLists mkl = new MergeKLists();
        ListNode res = mkl.mergeKLists(lists);
        System.out.println(res.toString());
    }
}
