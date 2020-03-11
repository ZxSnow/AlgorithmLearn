package List;

public class Practice5 {
    /**
     * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/6/linked-list/45/
     * @param args
     */
    public static void main(String[] args) {
        int[] arr = {1, 0, 1};
        Practice5 p = new Practice5();
        ListNode head = merge(arr);

        boolean flag = p.isPalindrome(head);
        System.out.println(flag);

    }

    public boolean isPalindrome(ListNode head) {
        ListNode before = head;
        ListNode after = reserve(head);

        while (before != null) {
            if (before.val != after.val) {
                return false;
            }
            before = before.next;
            after = after.next;
        }

        return true;
    }

    private ListNode reserve(ListNode head) {
        ListNode result = null;
        ListNode node;
        while (head != null) {
            node = new ListNode(head.val);
            node.next = result;
            result = node;

            head = head.next;
        }
        return result;
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
