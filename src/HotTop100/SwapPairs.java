package HotTop100;

import List.ListNode;

public class SwapPairs {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode low = head;
        ListNode high = head.next;
        ListNode res = high;
        ListNode pre = null;
        boolean lowFirst = true;

        //前进两步
        while (low != null && high != null) {
            if (lowFirst) {
                swap(pre, low, high);
                pre = low;
            } else {
                swap(pre, high, low);
                pre = high;
            }

            lowFirst = !lowFirst;
            if (high.next == null || low.next == null) {
                break;
            }
            low = low.next.next;
            high = high.next.next;
        }
        return res;
    }

    public void swap(ListNode pre, ListNode low, ListNode high) {
        low.next = high.next;
        high.next = low;
        if (pre != null) {
            pre.next = high;
        }
    }

    public ListNode swapPairs1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = head.next;
        head.next = swapPairs1(newHead.next);
        newHead.next = head;
        return newHead;
    }

    public ListNode swapPairs2(ListNode head) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode temp = dummyHead;
        while (temp.next != null && temp.next.next != null) {
            ListNode node1 = temp.next;
            ListNode node2 = temp.next.next;
            temp.next = node2;
            node1.next = node2.next;
            node2.next = node1;
            temp = node1;
        }
        return dummyHead.next;
    }


    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);

        SwapPairs sp = new SwapPairs();
        ListNode res = sp.swapPairs(head);
        System.out.println(res);
    }
}
