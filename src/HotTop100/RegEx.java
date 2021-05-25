package HotTop100;

import java.util.HashMap;
import java.util.Map;

public class RegEx {
    /**
     * 正则表达式匹配
     * https://leetcode-cn.com/problems/regular-expression-matching/
     *
     * @param s
     * @param p
     * @return
     */
    public boolean isMatch(String s, String p) {
        return dp(s, 0, p, 0);
    }


    Map<String, Boolean> memo = new HashMap<>();

    public boolean dp(String s, int i, String p, int j) {
        //base case
        int m = s.length();
        int n = p.length();
        if (j == n) {
            //通配符串走到了结尾，判断文本串是否在结尾
            return i == m;
        }
        if (i == m) {
            // 如果能匹配空串，一定是字符和 * 成对儿出现
            if ((n - j) % 2 == 1) {
                return false;
            }
            // 检查是否为 x*y*z* 这种形式
            for (; j + 1 < n; j += 2) {
                if (p.charAt(j + 1) != '*') {
                    return false;
                }
            }
            return true;
        }
        String key = i + "," + j;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        boolean res = false;

        if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.') {
            //判断p[j+1]是否等于*
            if (j < p.length() - 1 && p.charAt(j + 1) == '*') {
                // 匹配*（可能0次，可能多次，存在选择问题）
                res = dp(s, i, p, j + 2) || dp(s, i + 1, p, j);
            } else {
                res = dp(s, i + 1, p, j + 1);
            }
        } else {
            //此时s[i]!=p[j]，如果p[j+1]=='*'，就还有匹配的余地，只能匹配0次
            if (j < p.length() - 1 && p.charAt(j + 1) == '*') {
                res = dp(s, i, p, j + 2);
            }
        }

        memo.put(key, res);

        return res;
    }
}
