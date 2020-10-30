package List.medium;

import List.ListNode;

public class OddEven {

    public ListNode oddEvenList(ListNode head) {
        ListNode res = head;
        ListNode slow = head.next;
        ListNode fast = head.next.next;
        while (fast != null) {
            //进行交换
            int temp = slow.val;
            slow.val = fast.val;
            fast.val = temp;

            //继续往下走
            slow = slow.next;
            //fast因为要走两步，所以要慎重
            if (fast.next == null) {
                //快指针已经走到头了
            } else if (fast.next.next == null) {
                //此时需要将倒数二三元素交换
            }
        }
        return res;
    }
}
