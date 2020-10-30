package Array.medium;

import java.util.*;

public class LongestSubstring {
    /**
     * 无重复字符的最长子串
     * https://leetcode-cn.com/leetbook/read/top-interview-questions-medium/xv2kgi/
     */
    /**
     * 双层嵌套循环，时间复杂度较高
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            int cont = 1;
            Map<Character, Integer> map = new HashMap<>();
            map.put(s.charAt(i), i);
            for (int j = i + 1; j < s.length(); j++) {
                char key = s.charAt(j);
                if (map.containsKey(key)) {
                    break;
                } else {
                    cont++;
                    map.put(key, j);
                }
            }
            res = Math.max(res, cont);
        }
        return res;
    }

    /**
     * 滑动窗口方式
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring1(String s) {
        int left = 0;
        int right = 0;
        int res = 0;
        Map<Character, Integer> map = new HashMap<>();
        while (right < s.length()) {
            char c = s.charAt(right);
            right++;
            if (map.containsKey(c)) {
                res = Math.max(res, right - left - 1);
                left = Math.max(map.get(c) + 1, left);
                map.put(c, right - 1);
            } else {
                map.put(c, right - 1);
            }
        }

        return Math.max(res, right - left);
    }

    public static void main(String[] args) {
        LongestSubstring ls = new LongestSubstring();
        int res = ls.lengthOfLongestSubstring1("abba");
        System.out.println(res);
    }
}
