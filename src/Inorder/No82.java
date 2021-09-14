package Inorder;

import List.ListNode;

public class No82 {
    /**
     * 向前比较
     *
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0, head);
        ListNode res = dummy;
        int cur = Integer.MAX_VALUE;
        ListNode node = head;

        while (node != null) {
            while (node != null && node.val == cur) {
                node = node.next;
            }
            dummy.next = node;
            if (node == null)
                break;
            cur = node.val;
            node = node.next;
            if (node != null && node.val != dummy.next.val)
                dummy = dummy.next;
        }
        return res.next;
    }

    /**
     * 向后比较
     *
     * @param head
     * @return
     */
    public ListNode deleteDuplicates1(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode res = new ListNode(0, head);
        ListNode pre = res, node = head;

        while (node != null && node.next != null) {
            if (node.val == node.next.val) {
                //将node移动到重复节点的最后一个节点
                //例：node = 1 -> 1 -> 1 -> 2，移动后的node = 1 -> 2
                while (node.next != null && node.val == node.next.val) {
                    node = node.next;
                }
                //执行删除
                pre.next = node.next;
            } else {
                //证明当前节点不会重复
                pre = node;
            }
            node = node.next;
        }

        return res.next;
    }

    public static void main(String[] args) {
        No82 no = new No82();
        int[] nums = {1, 1, 1, 2, 2, 3};
        ListNode node = ListNode.arrayToListNode(nums);
        ListNode res = no.deleteDuplicates1(node);
        System.out.println(res);
    }
}
