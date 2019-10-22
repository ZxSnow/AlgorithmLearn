package Array;

public class Practice7 {
    /**
     * 题目：加一
     * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
     * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
     * 你可以假设除了整数 0 之外，这个整数不会以零开头。
     * 示例：
     * 输入: [1,2,3]
     * 输出: [1,2,4]
     * 解释: 输入数组表示数字 123。
     * 题目地址:
     * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/1/array/27/
     */
    public static void main(String[] args) {
        int[] digits = {9, 9, 9, 9};
        int[] result = plusOne(digits);
        for (int i : result) {
            System.out.print(i + " ");
        }
    }


    public static int[] plusOne(int[] digits) {
        boolean flag = false;
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] == 9) {
                digits[i] = 0;
                if (i - 1 < 0) {
                    flag = true;
                    break;
                }
            } else {
                digits[i] += 1;
                break;
            }
        }
        if (flag) {
            int[] result = new int[digits.length + 1];
            for (int i = 1; i < digits.length + 1; i++) {
                result[i] = 0;
            }
            result[0] = 1;
            return result;
        }
        return digits;
    }

}
