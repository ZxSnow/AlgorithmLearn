package Inorder;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class No829 {
    /**
     * 依次遍历：超时
     *
     * @param n
     * @return
     */
    public static int consecutiveNumbersSum(int n) {
        long[] preSum = new long[n + 1];
        Map<Long, Integer> map = new HashMap<>();
        map.put(0L, 0);
        int cnt = 0;
        for (int i = 1; i <= n; i++) {
            preSum[i] = preSum[i - 1] + i;
            map.put(preSum[i], i);

            if (preSum[i] >= n) {
                if (map.containsKey(preSum[i] - n)) {
                    cnt++;
                }
            }
        }
        return cnt;
    }

    /**
     * 利用等差数列特性
     *
     * @param n
     * @return
     */
    public static int consecutiveNumbersSum1(int n) {
        int sum = 0, res = 0, i = 1;
        while (sum < n) {
            if ((n - sum) % i == 0) res++;
            sum += i;
            i++;
        }
        return res;
    }

    public static void main(String[] args) {
        int res = consecutiveNumbersSum1(501734);
        System.out.println(res);
    }
}
