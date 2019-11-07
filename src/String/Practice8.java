package String;

public class Practice8 {
    /**
     * 题目：报数
     * <p>
     * 题目地址：
     * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/5/strings/39/
     */
    public static void main(String[] args) {
        System.out.println(countAndSay(3));
    }

    public static String countAndSay(int n) {
        String result = "1-";
        for (int i = 0; i < n-1; i++) {
            result = count(result);
        }
        result = result.replace("-", "");
        return result;
    }

    public static String count(String str) {
        String result = "";
        int count = 0;
        String[] ss = str.split("-");
        String value = ss[0];
        for (String s : ss) {
            if (s.equals(value)) {
                count++;
            } else {
                result += count + "-" + value + "-";
                value = s;
                count = 1;
            }
        }
        result += count + "-" + value + "-";
        return result;
    }
}
