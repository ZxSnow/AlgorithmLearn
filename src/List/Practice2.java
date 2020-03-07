package List;

import java.io.IOException;

public class Practice2 {
    /**
     * 题目：删除链表的倒数第N个节点
     * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
     * 示例：
     * <p>
     * 给定一个链表: 1->2->3->4->5, 和 n = 2.
     * <p>
     * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
     * 题目地址：
     * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/6/linked-list/42/
     */
    public static void main(String[] args) throws IOException {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
//        head.next.next = new ListNode(3);
//        head.next.next.next = new ListNode(4);

        Practice2 p = new Practice2();
        printNode(p.test(head, 2));

    }

    public ListNode test(ListNode head, int n) {
//        ListNode dummy = head;
        int length = 0;
        ListNode node = head;
        while (node != null) {
            node = node.next;
            length++;
        }

        if (length == n) {
            head=head.next;
            return head;
        }

        length = length - n - 1;

        node = head;
        while (length > 0) {
            node = node.next;
            length--;
        }
        node.next = node.next.next;
        return head;

    }

    public ListNode removeNthFromEnd01(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        int length = 0;
        ListNode first = head;
        while (first != null) {
            length++;
            first = first.next;
        }

        length -= n;
        first = dummy;

        while (length > 0) {
            length--;
            first = first.next;
        }

        first.next = first.next.next;
        return dummy.next;
    }

    public ListNode removeNthFromEnd02(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode first = dummy;
        ListNode second = dummy;
        // Advances first pointer so that the gap between first and second is n nodes apart
        for (int i = 1; i <= n + 1; i++) {
            first = first.next;
        }
        // Move first to the end, maintaining the gap
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return dummy.next;
    }


    public static class ListNode {
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
