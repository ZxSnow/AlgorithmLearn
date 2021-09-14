package Inorder;

import java.util.Arrays;
import java.util.Stack;

public class No739 {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] res = new int[n];

        for (int i = n - 2; i >= 0; i--) {
            int cnt = 0;
            boolean flag = false;
            for (int j = i + 1; j < n; j++) {
                cnt++;
                if (temperatures[j] > temperatures[i]) {
                    flag = true;
                    break;
                }
            }
            if (flag) {
                res[i] = cnt;
            }
        }
        return res;
    }

    public int[] dailyTemperatures2(int[] temperatures) {
        int n = temperatures.length;
        int[] res = new int[n];

        for (int i = n - 2; i >= 0; i--) {
            if (temperatures[i] >= temperatures[i + 1]) {
                int j = i + 1 + res[i + 1];

                while (j < n - 1 && temperatures[i] >= temperatures[j] && res[j] != 0) {
                    j += res[j];
                }
                if (res[j] == 0 && temperatures[j] <= temperatures[i]) {
                    res[i] = 0;
                } else {
                    res[i] = j - i;
                }
            } else {
                res[i] = 1;
            }
        }
        return res;
    }

    public int[] dailyTemperaturesStack(int[] temp) {
        int n = temp.length;
        int[] res = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && temp[stack.peek()] <= temp[i]) {
                stack.pop();
            }
            res[i] = stack.isEmpty() ? 0 : stack.peek() - i;

            stack.push(i);
        }
        return res;
    }

    public static void main(String[] args) {
        No739 no = new No739();
        int[] temp = {73, 78, 75, 71, 69, 72, 76, 73};
        int[] res = no.dailyTemperaturesStack(temp);
        System.out.println(Arrays.toString(res));
    }
}
