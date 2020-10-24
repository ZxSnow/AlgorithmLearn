package Array.medium;

import java.util.*;

public class LetterGroup {
    /**
     * https://leetcode-cn.com/leetbook/read/top-interview-questions-medium/xvaszc/
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            int[] nums = new int[26];
            char[] strChar = str.toCharArray();
            for (char sc : strChar) {
                nums[sc - 'a'] += 1;
            }
            String key = Arrays.toString(nums);
            if (map.containsKey(key)) {
                List<String> list = map.get(key);
                list.add(str);
                map.replace(key, list);
            } else {
                List<String> list = new ArrayList<>();
                list.add(str);
                map.put(key, list);
            }
        }
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        LetterGroup lg = new LetterGroup();
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        int[] nums = {0, 1, 3, 5};
        System.out.println(Arrays.toString(nums));
        lg.groupAnagrams(strs);
    }
}
