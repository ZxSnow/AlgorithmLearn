package Today360;

import java.util.Scanner;

public class 回文数变换 {
    public int cost(String s) {
        int len = s.length();
        int[] add = {0, 100, 200, 360, 220};
        int[] del = {0, 120, 350, 200, 320};
        int[][] dp = new int[len + 1][len + 1];
        for (int i = s.length() - 1; i > 0; i--) {
            for (int j = i + 1; j < len; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1];
                } else {
                    int idxI = s.charAt(i) - '0';
                    int idxJ = s.charAt(j) - '0';
                    dp[i][j] = Math.min(dp[i + 1][j] + Math.min(add[idxI], del[idxI]),
                            dp[i][j - 1] + Math.min(add[idxJ], del[idxJ]));
                }
            }
        }
        return dp[1][len];
    }

    int[] addCost = new int[]{0, 100, 200, 360, 220};
    int[] deleteCost = new int[]{0, 120, 350, 200, 320};

    public void cost1(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        for (int L = 2; L <= n; L++) {
            for (int i = 0; i < n; i++) {
                int j = i + L - 1;
                if (j >= n) break;
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1];
                } else {
                    dp[i][j] = Math.min(
                            Math.min(dp[i + 1][j] + addCost[s.charAt(i) - '0'], dp[i + 1][j] + deleteCost[s.charAt(i) - '0']),
                            Math.min(dp[i][j - 1] + addCost[s.charAt(j) - '0'], dp[i][j - 1] + deleteCost[s.charAt(j) - '0'])
                    );
                }
            }
        }
        System.out.println(dp[0][n - 1]);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] str = sc.nextLine().toCharArray();
        int len = str.length;
        //dp[i][j]代表str[i....j]变换为回文串的代价
        int[][] dp = new int[len][len];
        //添加 删除的代价
        int[] add = {0, 100, 200, 360, 220};
        int[] delete = {0, 120, 350, 200, 320};
        //遍历区间长度从2开始 长度为1的全是回文默认为0
        for (int L = 2; L <= len; L++) {
            //遍历左端点
            for (int i = 0; i < len; i++) {
                //右端点
                int j = i + L - 1;
                //右端越界退出此次长度循环
                if (j >= len) break;
                if (str[i] == str[j]) {
                    //长度为2时使用初始值0
                    if (L > 2) {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                } else {
                    //dp[i+1][l] 右边添加一个str[i]或者左边删除
                    //dp[i][l-1] 左边添加一个str[j]或者右边删除
                    dp[i][j] = Math.min(
                            dp[i + 1][j] + Math.min(add[str[i] - '0'], delete[str[i] - '0']),
                            dp[i][j - 1] + Math.min(add[str[j] - '0'], delete[str[j] - '0'])
                    );
                }
            }
        }
        System.out.println(dp[0][len - 1]);
    }
}
