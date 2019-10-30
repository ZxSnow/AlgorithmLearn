package String;

public class Practice2 {
    /**
     * 题目：整数反转
     * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
     * 示例 1:
     * 输入: 123
     * 输出: 321
     * <p>
     * 题目地址：
     * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/5/strings/33/
     */
    public static void main(String[] args) {
        int x = 1534236469;
        System.out.println(reverse(x));
    }

    public static int reverse(int x) {
        int result = 0;
        boolean flag = false;
        if (x < 0) {
            x = -x;
            flag = true;
        }
        while (x > 0) {
            int pop = x % 10;
            x = x / 10;
            if (result > Integer.MAX_VALUE / 10 || result == Integer.MAX_VALUE/10 && x > 7) {
                return 0;
            }
            result = pop + result * 10;

        }
        if (flag) {
            return -result;
        }
        return result;
    }
}
