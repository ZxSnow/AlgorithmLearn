package List.primary;

import java.util.HashSet;
import java.util.Set;

public class Practice6 {
    /**
     * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/6/linked-list/46/
     */
    public static void main(String[] args) {

    }

    public boolean hasCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        while (head!=null){
            if(set.contains(head)){
                return true;
            }
            set.add(head);

            head = head.next;
        }

        return false;
    }
    //快慢指针
    public boolean hasCycle01(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
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
}
