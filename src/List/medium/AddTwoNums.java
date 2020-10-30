package List.medium;

import List.ListNode;

import java.util.ArrayList;
import java.util.List;

public class AddTwoNums {
    /**
     * 两数相加
     * https://leetcode-cn.com/leetbook/read/top-interview-questions-medium/xvw73v/
     * 会超时
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int sum = getValue(l1) + getValue(l2);
        ListNode res = new ListNode(sum % 10);
        while (sum > 0) {
            sum /= 10;
            res.next = new ListNode(sum % 10);
        }
        return res;
    }

    public int getValue(ListNode node) {
        if (node == null) {
            return 0;
        }
        int sum = 0;
        int cnt = 1;
        while (node.next != null) {
            sum += cnt * node.val;
            cnt *= 10;
        }
        return sum;
    }

    public ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        ListNode node1 = l1;
        ListNode node2 = l2;
        List<ListNode> list = new ArrayList<>();
        boolean flag = false;
        int cnt = 0;
        while (node1 != null || node2 != null || flag) {
            int val1 = node1 == null ? 0 : node1.val;
            int val2 = node2 == null ? 0 : node2.val;
            int rs = val1 + val2;
            if (flag) {
                rs++;
            }
            if (rs >= 10) {
                rs = rs % 10;
                flag = true;
            } else {
                flag = false;
            }
            ListNode ln = new ListNode(rs);
            list.add(ln);
            if (cnt > 0) {
                list.get(cnt - 1).next = list.get(cnt);
            }
            cnt++;
            node1 = node1 == null ? null : node1.next;
            node2 = node2 == null ? null : node2.next;
        }
        return list.size() > 0 ? list.get(0) : new ListNode();
    }


    public static void main(String[] args) {
        ListNode node1 = new ListNode(9);
        node1.next = new ListNode(9);
        node1.next.next = new ListNode(9);
        ListNode node2 = new ListNode(9);
        node2.next = new ListNode(9);
//        node2.next.next = new ListNode(4);
        AddTwoNums at = new AddTwoNums();
        ListNode res = at.addTwoNumbers1(node1, node2);
        System.out.println(res);
    }
}
