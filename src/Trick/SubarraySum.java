package Trick;

import java.util.HashMap;

public class SubarraySum {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        int ans = 0, sumCur = 0;
        for (int num : nums) {
            //不断的计算num[0-cur]的前缀和
            sumCur += num;

            //想找的num[0-j] 如果有 num[i-j]即为满足条件的
            int tmp = sumCur - k;
            if (map.containsKey(tmp)) {
                ans += map.get(tmp);
            }
            map.put(sumCur, map.getOrDefault(sumCur, 0) + 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {3, 5, 2, -2, 4, 1};
        SubarraySum ss = new SubarraySum();
        int res = ss.subarraySum(nums, 5);
        System.out.println(res);
    }
}
