package Inorder;

import java.util.HashMap;
import java.util.Map;

public class No76 {
    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";

        No76 no = new No76();
        String s1 = no.minWindow1(s, t);
        System.out.println(s1);
    }

    public String minWindow(String s, String t) {
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            need.put(t.charAt(i), need.getOrDefault(t.charAt(i), 0) + 1);
        }
        int min = s.length();
        int left = 0, right = 0;
        String res = "";
        while (right < s.length()) {
            char r = s.charAt(right++);
            window.put(r, window.getOrDefault(r, 0) + 1);

            while (satisfy(need, window)) {
                if (right - left - 1 < min) {
                    min = right - left;
                    res = s.substring(left, right);
                }

                char l = s.charAt(left++);
                window.put(l, window.getOrDefault(l, 0) - 1);
            }
        }
        return res;
    }

    public String minWindow1(String s, String t) {
        int[] need = new int[128];
        int[] window = new int[128];

        for (int i = 0; i < t.length(); i++) {
            need[t.charAt(i)]++;
        }
        int min = s.length();
        int left = 0, right = 0;
        String res = "";
        int cnt = t.length();
        while (right < s.length()) {
            char r = s.charAt(right++);
            if (window[r]++ < need[r]) {
                cnt--;
            }

            while (cnt == 0) {
                if (right - left - 1 < min) {
                    min = right - left;
                    res = s.substring(left, right);
                }

                char l = s.charAt(left++);
                if (need[l] == window[l]--) {
                    cnt++;
                }
            }
        }
        return res;
    }

    //todo 可对本方法进行优化
    public boolean satisfy(Map<Character, Integer> need, Map<Character, Integer> window) {
        for (Character key : need.keySet()) {
            if (!window.containsKey(key) || window.get(key) < need.get(key)) {
                return false;
            }
        }
        return true;
    }

    public String minWindow2(String s, String t) {
        if (s == null || s.length() == 0 || t == null || t.length() == 0) {
            return "";
        }
        int[] need = new int[128];
        //记录需要的字符的个数
        for (int i = 0; i < t.length(); i++) {
            need[t.charAt(i)]++;
        }
        //l是当前左边界，r是当前右边界，size记录窗口大小，count是需求的字符个数，start是最小覆盖串开始的index
        int l = 0, r = 0, size = Integer.MAX_VALUE, count = t.length(), start = 0;
        //遍历所有字符
        while (r < s.length()) {
            char c = s.charAt(r);
            if (need[c] > 0) {//需要字符c
                count--;
            }
            need[c]--;//把右边的字符加入窗口
            if (count == 0) {//窗口中已经包含所有字符
                while (l < r && need[s.charAt(l)] < 0) {
                    need[s.charAt(l)]++;//释放右边移动出窗口的字符
                    l++;//指针右移
                }
                if (r - l + 1 < size) {//不能右移时候挑战最小窗口大小，更新最小窗口开始的start
                    size = r - l + 1;
                    start = l;//记录下最小值时候的开始位置，最后返回覆盖串时候会用到
                }
                //l向右移动后窗口肯定不能满足了 重新开始循环
                need[s.charAt(l)]++;
                l++;
                count++;
            }
            r++;
        }
        return size == Integer.MAX_VALUE ? "" : s.substring(start, start + size);
    }
}
