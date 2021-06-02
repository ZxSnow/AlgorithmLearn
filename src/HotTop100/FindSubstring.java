package HotTop100;

import java.util.*;

public class FindSubstring {
    //s中位置对应的字符
    Map<Integer, String> map = new HashMap<>();
    //words中每个word需要的个数
    Map<String, Integer> need = new HashMap<>();


    public List<Integer> findSubstring(String s, String[] words) {
        for (String word : words) {
            if (need.containsKey(word)) {
                need.put(word, need.get(word) + 1);
            } else {
                need.put(word, 1);
            }
        }
        help(s, words[0].length());
        return slide(words.length, words[0].length());
    }

    /**
     * @param s
     * @param word
     * @return
     */
    public void help(String s, String word) {
        int idx = 0;
        while (idx <= s.length() - word.length()) {
            int tmp = s.indexOf(word, idx);
            if (tmp == -1) {
                break;
            }
            map.put(tmp, word);
            idx = tmp + 1;
        }
    }

    public void help(String s, int cnt) {
        int idx = 0;
        while (idx < s.length()) {
            String sub = s.substring(idx, idx + cnt);
            if (need.containsKey(sub)) {
                map.put(idx, sub);
            }
            idx += cnt;
        }
    }


    public List<Integer> slide(int n, int gap) {
        List<Integer> result = new ArrayList<>();
        Integer[] values = map.keySet().toArray(new Integer[0]);
        Arrays.sort(values);

        int left = 0;
        while (left < values.length) {
            boolean flag = contain(values, left, values.length, gap, n);
            if (flag) {
                result.add(values[left]);
            }
            left++;
        }
        return result;
    }

    public boolean contain(Integer[] nums, int low, int high, int gap, int n) {
        Map<String, Integer> needed = new HashMap<>(need);
        int idx = low;
        int tmp = nums[low] - gap;
        int cnt = 0;

        while (idx < high && cnt < n) {
            int set = nums[idx];
            if (set != tmp + gap) {
                idx++;
                continue;
            }
            String word = map.get(set);
            int ne = needed.get(word);
            if (ne > 0) {
                needed.put(word, ne - 1);
            } else {
                return false;
            }
            idx++;
            tmp = set;
            cnt++;
        }
        for (Integer value : needed.values()) {
            if (value != 0) {
                return false;
            }
        }
        return true;
    }

    public List<Integer> findSubstring1(String s, String[] words) {
        Map<String, Integer> allWords = new HashMap<>();
        for (String word : words) {
            allWords.put(word, allWords.getOrDefault(word, 0) + 1);
        }
        int wordNum = words.length, wordLen = words[0].length();
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < s.length() - wordNum * wordLen + 1; i++) {
            Map<String, Integer> subWords = new HashMap<>();
            int index = i;
            while (index < i + wordNum * wordLen) {
                String curWord = s.substring(index, index + wordLen);
                if (!allWords.containsKey(curWord) || subWords.get(curWord).equals(allWords.get(curWord))) {
                    break;
                }
                subWords.put(curWord, subWords.getOrDefault(curWord, 0) + 1);
                index += wordLen;
            }
            if (index == i + wordNum * wordLen) {
                res.add(i);
            }
        }
        return res;
    }

    /**
     * 滑动窗口
     *
     * @param s
     * @param words
     * @return
     */
    public List<Integer> findSubstring2(String s, String[] words) {
        //将所有的单词放到map中
        Map<String, Integer> needed = new HashMap<>();
        for (String word : words) {
            needed.put(word, needed.getOrDefault(word, 0) + 1);
        }
        int total = words.length;
        int single = words[0].length();
        List<Integer> res = new ArrayList<>();
        int idx = 0;

        while (idx <= s.length() - single * total) {
            int left = idx, right;
            right = idx;
            Map<String, Integer> window = new HashMap<>();
            int cnt = 0;

            while (right < idx + single * total) {
                String sub = s.substring(right, right + single);
                right += single;
                //窗口更新
                if (needed.containsKey(sub)) {
                    window.put(sub, window.getOrDefault(sub, 0) + 1);
                    if (window.get(sub).equals(needed.get(sub))) {
                        cnt++;
                    }
                }
                while (cnt == needed.size()) {
                    if (right - left == single * total) {
                        res.add(left);
                    }
                    String tmp = s.substring(left, left + single);
                    left += single;

                    if (needed.containsKey(tmp)) {
                        if (window.get(tmp).equals(needed.get(tmp))) {
                            cnt--;
                        }
                        window.put(tmp, window.get(tmp) - 1);
                    }
                }
            }
            idx++;
        }

        return res;

    }


    public static void main(String[] args) {
        FindSubstring fs = new FindSubstring();
        String s = "barfoothefoobarman";
        String[] words = {"foo", "bar"};
        List<Integer> res = fs.findSubstring2(s, words);
        System.out.println(res);
    }
}
