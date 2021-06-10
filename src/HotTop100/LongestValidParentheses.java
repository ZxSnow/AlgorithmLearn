package HotTop100;

public class LongestValidParentheses {
    public int longestValidParentheses(String s) {
        int right = 0;
        int left = 0;
        int res = 0;

        int l = 0;
        int r = 0;
        boolean invalid = false;

        while (right < s.length()) {
            char c = s.charAt(right);
            right++;
            if (c == '(') {
                l++;
            } else {
                if (r >= l) {
                    invalid = true;
                } else {
                    r++;
                }
            }

            if (invalid) {
                int tmp = find(s, left, right);
                res = Math.max(res, tmp);
                l = 0;
                r = 0;
                left = right;
                invalid = false;
            }
        }
        int tmp = find(s, left, right);
        res = Math.max(res, tmp);

        return res;
    }

    public int find(String s, int left, int right) {
        int res = 0;
        int l = 0, r = 0;
        int i = right - 1;
        boolean invalid = false;

        while (i >= left) {
            char c = s.charAt(i);
            i--;
            if (c == ')') {
                r++;
            } else {
                if (l >= r) {
                    invalid = true;
                } else {
                    l++;
                }
            }
            if (invalid) {
                res = Math.max(res, r * 2);
                l = 0;
                r = 0;
                invalid = false;
            }
        }
        res = Math.max(res, Math.min(l, r) * 2);
        return res;
    }

    public static void main(String[] args) {
        LongestValidParentheses lvp = new LongestValidParentheses();

        String s = "";

        int res = lvp.longestValidParentheses(s);
        System.out.println(res);
    }
}
