package String;

import java.util.HashMap;
import java.util.Map;

public class Practice3 {
    /**
     * 题目：字符串中的第一个唯一字符
     * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
     * <p>
     * 案例:
     * s = "leetcode"
     * 返回 0.
     * <p>
     * s = "loveleetcode",
     * 返回 2.
     * 题目地址：
     * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/5/strings/34/
     */
    public static void main(String[] args) {
        String s = "leetcode";
        System.out.println(firstUniqChar(s));
    }

    public static int firstUniqChar(String s) {
        int result = -1;
        char[] array = s.toCharArray();
        if (array.length == 1) {
            return 0;
        }

        for (int i = 0; i < array.length; i++) {
            boolean flag = true;
            for (int j = 0; j < array.length; j++) {
                if (array[i] == array[j] && i != j) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                return i;
            }
        }
        return result;
    }

}
