package Inorder;

import java.util.HashMap;
import java.util.Map;

public class No395 {
    /**
     * 至少有 K 个重复字符的最长子串
     * https://leetcode-cn.com/problems/longest-substring-with-at-least-k-repeating-characters/
     */
    public int longestSubstring(String s, int k) {
        if (k == 1) {
            return s.length();
        }
        if (s.length() < k)
            return 0;
        return dfs(s, 0, s.length() - 1, k);

    }

    int dfs(String s, int l, int r, int k) {
        if (r - l < k - 1)
            return 0;
        int[] cnt = new int[26];
        for (int i = l; i <= r; i++) {
            cnt[s.charAt(i) - 'a']++;
        }

        char split = 0;
        for (int i = 0; i < 26; i++) {
            if (cnt[i] > 0 && cnt[i] < k) {
                split = (char) (i + 'a');
                break;
            }
        }
        if (split == 0) {
            return r - l + 1;
        }

        int i = l;
        int ret = 0;
        while (i <= r) {
            while (i <= r && s.charAt(i) == split) {
                i++;
            }
            if (i > r) {
                break;
            }
            int start = i;
            while (i <= r && s.charAt(i) != split) {
                i++;
            }

            int length = dfs(s, start, i - 1, k);
            ret = Math.max(ret, length);
        }
        return ret;
    }


    public boolean isValid(String s, int l, int r, int k) {
        if (r - l < k)
            return false;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = l; i < r; i++) {
            char cur = s.charAt(i);
            map.put(cur, map.getOrDefault(cur, 0) + 1);
        }
        for (Character c : map.keySet()) {
            if (map.get(c) < k) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        No395 no = new No395();
        String s = "aaabcbb";
        int res = no.longestSubstring(s, 3);
        System.out.println(res);
    }
}
