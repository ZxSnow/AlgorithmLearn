package Array.medium;

public class LongestPalindrome {
    /**
     * 最长回文子串
     * https://leetcode-cn.com/leetbook/read/top-interview-questions-medium/xvn3ke/
     *
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }
        int strLen = s.length();
        int maxStart = 0;  //最长回文串的起点
        int maxEnd = 0;    //最长回文串的终点
        int maxLen = 1;  //最长回文串的长度

        boolean[][] dp = new boolean[strLen][strLen];

        for (int r = 1; r < strLen; r++) {
            for (int l = 0; l < r; l++) {
                if (s.charAt(l) == s.charAt(r) && (r - l <= 2 || dp[l + 1][r - 1])) {
                    dp[l][r] = true;
                    if (r - l + 1 > maxLen) {
                        maxLen = r - l + 1;
                        maxStart = l;
                        maxEnd = r;

                    }
                }

            }

        }
        return s.substring(maxStart, maxEnd + 1);
    }

    public String longestPalindromeZx(String s) {
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            String res1 = help(s, i, i);
            String res2 = help(s, i, i + 1);
            res = res.length() > res1.length() ? res : res1;
            res = res.length() > res2.length() ? res : res2;
        }
        return res;
    }

    public String help(String str, int l, int r) {
        while (l >= 0 && r < str.length()) {
            if (str.charAt(l) == str.charAt(r)) {
                l--;
                r++;
            }else {
                break;
            }
        }
        return str.substring(l + 1, r);
    }

    public static void main(String[] args) {
        LongestPalindrome lp = new LongestPalindrome();
        String res = lp.longestPalindromeZx("babad");
        System.out.println(res);
    }
}
