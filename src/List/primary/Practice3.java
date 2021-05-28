package List.primary;

import List.ListNode;

public class Practice3 {
    /**
     * 题目地址：
     * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/6/linked-list/43/
     */
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
//        head.next = new ListNode(2);
//        head.next.next = new ListNode(3);
//        head.next.next.next = new ListNode(4);

        System.out.println(reverseList(head));
    }

    public static ListNode reverseList(ListNode head) {
        ListNode node = head;
        ListNode result = null;
        ListNode ln;
        while (node != null) {
            ln = new ListNode(node.val);

            ln.next = result;
            result = ln;

            node = node.next;
        }

        return result;
    }

    public ListNode reverseList01(ListNode head) {
        //递归终止条件是当前为空，或者下一个节点为空
        if (head == null || head.next == null) {
            return head;
        }
        //这里的cur就是最后一个节点
        ListNode cur = reverseList(head.next);
        //这里请配合动画演示理解
        //如果链表是 1->2->3->4->5，那么此时的cur就是5
        //而head是4，head的下一个是5，下下一个是空
        //所以head.next.next 就是5->4
        head.next.next = head;
        //防止链表循环，需要将head.next设置为空
        head.next = null;
        //每层递归函数都返回cur，也就是最后一个节点
        return cur;
    }
}
