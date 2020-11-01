package List.medium;

import List.ListNode;

import java.util.ArrayList;
import java.util.List;

public class OddEven {

    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return head;
        }
        ListNode slow = head.next;
        ListNode fast = head.next.next;
        List<Integer> list = new ArrayList<>();
        int cnt = 2;
        while (fast != null) {
            //进行交换
            int temp = slow.val;
            slow.val = fast.val;
            fast.val = temp;

            if (cnt % 2 == 0) {
                list.add(temp);
            }
            //继续往下走
            slow = slow.next;
            cnt++;

            //fast因为要走两步，所以要慎重
            if (fast.next == null || fast.next.next == null) {
                //快指针已经走到头了
                //此时总数有奇数个，对slow指针之后的进行排序
                sort(slow, list, cnt);
                break;
            }
            fast = fast.next.next;
        }
        return head;
    }

    public void sort(ListNode head, List<Integer> list, int cnt) {
        int idx = 0;
        while (head != null) {
            if (cnt % 2 == 0) {
                list.add(head.val);
            }
            head.val = list.get(idx);
            head = head.next;
            idx++;
            cnt++;
        }
    }

    public ListNode oddEvenList1(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode rtn = head;
        ListNode evenHead = rtn.next;
        ListNode odd = head, even = head.next;
        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return rtn;
    }

    public static void main(String[] args) {
        OddEven oe = new OddEven();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = new ListNode(7);
//        head.next.next.next.next = new ListNode(8);
        ListNode res = oe.oddEvenList1(head);
        System.out.println(res);
    }
}
