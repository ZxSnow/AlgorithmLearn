package String;

public class Practice9 {
    /**
     * 题目：最长公共前缀
     * <p>
     * 编写一个函数来查找字符串数组中的最长公共前缀。
     * 如果不存在公共前缀，返回空字符串 ""。
     * <p>
     * 示例 1:
     * 输入: ["flower","flow","flight"]
     * 输出: "fl"
     * <p>
     * 题目地址：
     * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/5/strings/40/
     */
    public static void main(String[] args) {
        String[] strs = {""};
        System.out.println(longestCommonPrefix(strs));
    }

    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        } else if (strs.length == 1) {
            return strs[0];
        }
        String common = commonPrefix(strs[0], strs[1]);
        if (common.equals("")) {
            return "";
        }
        for (int i = 2; i < strs.length; i++) {
            common = commonPrefix(common, strs[i]);
        }

        return common;
    }

    public static String commonPrefix(String str1, String str2) {
        String result = "";
        int length = 0;
        if (str1.length() > str2.length()) {
            length = str2.length();
        } else {
            length = str1.length();
        }
        for (int i = 0; i < length; i++) {
            if (str1.charAt(i) == str2.charAt(i)) {
                result += str1.charAt(i);
            } else {
                break;
            }
        }
        return result;
    }

    public String longestCommonPrefix1(String[] strs) {
        if (strs.length == 0) return "";
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++)
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "";
            }
        return prefix;
    }
}
