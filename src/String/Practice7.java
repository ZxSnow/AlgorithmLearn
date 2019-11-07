package String;

public class Practice7 {
    /**
     * 题目：实现 strStr()
     * 实现 strStr() 函数。
     * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
     * <p>
     * 说明:
     * 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
     * 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。
     * <p>
     * 示例 1:
     * 题目地址：
     * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/5/strings/38/
     */
    public static void main(String[] args) {
        String s = "";
        System.out.println(strStr("","a"));
    }
    public static int strStr(String haystack, String needle) {
        if(needle.isEmpty()){
            return 0;
        }
        if (haystack == null || haystack.isEmpty()) {
            return -1;
        }
        if (!haystack.contains(needle)) {
            return -1;
        }

        return haystack.indexOf(needle);
    }

}
