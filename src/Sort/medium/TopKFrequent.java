package Sort.medium;

import java.util.*;

public class TopKFrequent {
    /**
     * 前 K 个高频元素
     * https://leetcode-cn.com/leetbook/read/top-interview-questions-medium/xvzpxi/
     */
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            if (map.containsKey(i)) {
                map.replace(i, map.get(i) + 1);
            } else {
                map.put(i, 1);
            }
        }
        List<Integer> max = new ArrayList<>();
        max.add(0);
        List<Integer> res = new ArrayList<>();

        for (Integer key : map.keySet()) {
            Integer cnt = map.get(key);
            for (int i = 0; i < max.size(); i++) {
                if (cnt > max.get(i)) {
                    max.add(i, cnt);
                    res.add(i, key);
                    break;
                }
            }
        }
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = res.get(i);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 3, 1, 2, 4, 5, 5, 6, 7, 7, 8, 2, 3, 1, 1, 1, 10, 11, 5, 6, 2, 4, 7, 8, 5, 6};
        TopKFrequent tf = new TopKFrequent();
        System.out.println(Arrays.toString(tf.topKFrequent(nums, 10)));
    }
}
