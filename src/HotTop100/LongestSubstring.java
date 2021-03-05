package HotTop100;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }
        int max = 0;
        // 维护窗口大小
        int left = 0;
        int right = 0;
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char x = s.charAt(i);

            if (map.containsKey(x)) {
                max = Math.max(max, right - left + 1);
                int idx = map.get(x);
                left = idx + 1;
                right = i;
                Map<Character, Integer> newMap = new HashMap<>();
                for (int j = left; j <= right; j++) {
                    newMap.put(s.charAt(j), j);
                }
                map = newMap;
            } else {
                right = i;
                map.put(x, i);
            }
        }
        max = Math.max(max, right - left + 1);

        return max;
    }

    public static void main(String[] args) {
        String s = "";
        LongestSubstring ls = new LongestSubstring();
        System.out.println(ls.lengthOfLongestSubstring(s));
    }
}
