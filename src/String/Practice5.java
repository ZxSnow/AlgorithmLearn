package String;

public class Practice5 {
    /**
     * 题目：验证回文字符串
     * 题目地址：
     * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/5/strings/36/
     */
    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        boolean flag = isPalindrome(s);
        System.out.println(flag);
    }

    public static boolean isPalindrome(String s) {
        s = s.toLowerCase();
        StringBuilder newS = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= 'a' && c <= 'z' || c >= '0' && c <= '9') {
                newS.append(c);
            }
        }
        String origin = newS.toString();
        char[] reverse = origin.toCharArray();
        reverse(reverse, 0, origin.length()-1);
        for (int i = 0; i < reverse.length; i++) {
            if (origin.charAt(i) != reverse[i]) {
                return false;
            }
        }
        return true;
    }

    private static void reverse(char[] nums, int start, int end) {
        while (start < end) {
            char tempS = nums[start];
            char tempE = nums[end];
            nums[end] = tempS;
            nums[start] = tempE;
            start++;
            end--;
        }
    }
}
