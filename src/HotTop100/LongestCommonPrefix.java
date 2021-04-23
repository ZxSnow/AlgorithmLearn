package HotTop100;

public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        String pre = strs[0];
        for (int i = 1; i < strs.length; i++) {
            pre = help(pre, strs[i]);
            if (pre.equals("")) {
                return "";
            }
        }
        return pre;
    }

    public String help(String s1, String s2) {
        String res = "";
        int i = 0;
        while (i < s1.length() && i < s2.length()) {
            if (s1.charAt(i) == s2.charAt(i)) {
                res += s1.charAt(i);
                i++;
            } else {
                break;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String[] strs = {"dog","racecar","car"};
        LongestCommonPrefix lcp = new LongestCommonPrefix();
        String res = lcp.longestCommonPrefix(strs);
        System.out.println(res);
    }
}
