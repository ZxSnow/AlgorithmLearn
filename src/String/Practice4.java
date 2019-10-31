package String;

import java.util.HashMap;
import java.util.Map;

public class Practice4 {
    /**
     * 题目：有效的字母异位词
     * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
     * 示例 1:
     * <p>
     * 输入: s = "anagram", t = "nagaram"
     * 输出: true
     * 示例 2:
     * <p>
     * 输入: s = "rat", t = "car"
     * 输出: false
     * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/5/strings/35/
     */
    public static void main(String[] args) {
        String s = "a";
        String t = "ab";
        System.out.println(isAnagram0(s, t));
    }

    public static boolean isAnagram(String s, String t) {
        Map<Character, Integer> map0 = convert(s);
        Map<Character, Integer> map1 = convert(t);
        if (map0.size() < map1.size()) {
            return false;
        }
        for (char c : map0.keySet()) {
            if (!map1.containsKey(c)) {
                return false;
            }
            if (!map1.get(c).equals(map0.get(c))) {
                return false;
            }
        }
        return true;
    }

    public static Map<Character, Integer> convert(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                map.replace(c, map.get(c) + 1);
            } else {
                map.put(c, 0);
            }
        }
        return map;
    }

    public static boolean isAnagram0(String s, String t) {
        int[] count = new int[26];
        for (char ch : s.toCharArray()) {
            count[ch-'a']++;
        }
        for (char ch : t.toCharArray()) {
            count[ch-'a']--;
        }
        for (int i = 0; i < count.length; ++i) {
            if (count[i] != 0) return false;
        }
        return true;
    }
}
