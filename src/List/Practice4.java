package List;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Practice4 {
    /**
     * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/6/linked-list/44/
     * @param args
     */
    public static void main(String[] args) {

        int[] arr = {1, 2};
        ListNode node1 = merge(arr);
        int[] arr2 = {2, 4};
        ListNode node2 = merge(arr2);
        printNode(mergeTwoLists0(node1, node2));

    }

    public static ListNode mergeTwoLists0(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }

        if (l2 == null) {
            return l1;
        }

        if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }

    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        List<Integer> list = new ArrayList<>();
        put(l1, list);
        put(l2, list);

        list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (o1 > o2) {
                    return -1;
                } else if (o1.equals(o2)) {
                    return 0;
                }
                return 1;
            }
        });
        ListNode result = null;
        ListNode node;
        for (int val : list) {
            node = new ListNode(val);

            node.next = result;
            result = node;
        }

        return result;
    }

    public static ListNode merge(int[] arr) {
        ListNode result = null;
        ListNode node;
        for (int i = arr.length - 1; i >= 0; i--) {
            node = new ListNode(arr[i]);

            node.next = result;
            result = node;
        }

        return result;
    }

    public static void put(ListNode node, List<Integer> list) {
        while (node != null) {
            list.add(node.val);
            node = node.next;
        }
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    private static void printNode(ListNode node) {
        while (node.next != null) {
            System.out.print(node.val + "->");
            node = node.next;
        }
        System.out.print(node.val);
    }
}
