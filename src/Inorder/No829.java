package Inorder;

import java.util.HashMap;
import java.util.Map;

public class No829 {
    public static int consecutiveNumbersSum(int n) {
        String[] preSum = new String[n + 1];
        Map<String, Integer> map = new HashMap<>();
        map.put("0", 0);
        int cnt = 0;
        for (int i = 1; i <= n; i++) {
            preSum[i] = add(preSum[i - 1], i);
            map.put(preSum[i], i);

            if (compare(preSum[i], n)) {
                if (map.containsKey(add(preSum[i], -n))) {
                    cnt++;
                }
            }
        }
        return cnt;
    }

    public static String add(String num1, int num2) {
        String num = "";
        boolean flag = true;
        if (num2 > 0) {
            num = String.valueOf(num2);
        } else {
            num = String.valueOf(-num2);
            flag = false;
        }
        StringBuilder sb = new StringBuilder();
        int i = 0, j = 0;
        while (i <= num1.length() && j <= num.length()){


            i++;
            j++;
        }
        return sb.toString();
    }

    public static boolean compare(String num1, int num2) {
        return false;
    }

    public static void main(String[] args) {
        int res = consecutiveNumbersSum(9);
        System.out.println(res);
    }
}
