package String;

public class Practice6 {
    /**
     * 题目：字符串转换整数 (atoi)
     * 请你来实现一个 atoi 函数，使其能将字符串转换成整数。
     * 首先，该函数会根据需要丢弃无用的开头空格字符，直到寻找到第一个非空格的字符为止。
     * 当我们寻找到的第一个非空字符为正或者负号时，则将该符号与之后面尽可能多的连续数字组合起来，作为该整数的正负号；假如第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成整数。
     * 该字符串除了有效的整数部分之后也可能会存在多余的字符，这些字符可以被忽略，它们对于函数不应该造成影响。
     * <p>
     * 注意：假如该字符串中的第一个非空格字符不是一个有效整数字符、字符串为空或字符串仅包含空白字符时，则你的函数不需要进行转换。
     * 在任何情况下，若函数不能进行有效的转换时，请返回 0。
     * <p>
     * 说明：
     * 假设我们的环境只能存储 32 位大小的有符号整数，那么其数值范围为 [−231,  231 − 1]。如果数值超过这个范围，请返回  INT_MAX (231 − 1) 或 INT_MIN (−231) 。
     * 题目地址：
     * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/5/strings/37/
     */
    // TODO: 2019-11-07 溢出判断不成功
    public static void main(String[] args) {
        String s = "1";
        System.out.println(myAtoi(s));
    }

    public static int myAtoi(String str) {
        str = str.trim();
        char[] array = str.toCharArray();
        if (array.length <= 0) {
            return 0;
        }
        StringBuilder clear = new StringBuilder();
        boolean zero = false;

        boolean flag = false;
        if (array[0] == '-') {
            flag = true;
        } else if (array[0] >= '0' && array[0] <= '9') {
            clear.append(array[0]);
            if (array[0] == '0') {
                zero = true;
            }
        } else if (array[0] == '+') {

        } else {
            return 0;
        }

        if (array[1] == '0') {
            zero = true;
        }

        for (int i = 1; i < str.length(); i++) {
            if (array[1] == '0') {
                zero = true;
            }
            if (zero) {
                if (array[i] == '0') {
                    continue;
                }
                zero = false;
            }
            if (array[i] >= '0' && array[i] <= '9') {
                clear.append(array[i]);
            } else {
                break;
            }
        }
        Long l = 0L;
        for (int i = 0; i < clear.length(); i++) {
            l = l * 10 + (clear.charAt(i) - 48);
        }
        if (l > Integer.MAX_VALUE || l < 0 || clear.length() > 10) {
            if (flag) {
                return Integer.MIN_VALUE;
            }
            return Integer.MAX_VALUE;
        }
        if (flag) {
            return -l.intValue();
        }
        return l.intValue();
    }
}
