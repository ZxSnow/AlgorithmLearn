package Array.medium;

import java.util.HashMap;
import java.util.Map;

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

    public static void main(String[] args) {
        LongestSubstring ls = new LongestSubstring();
        ls.lengthOfLongestSubstring(" ");
    }
}
