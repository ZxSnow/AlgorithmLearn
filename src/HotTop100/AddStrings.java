package HotTop100;

import java.util.LinkedList;
import java.util.List;

public class AddStrings {
    /**
     * No.415 字符串相加
     * https://leetcode-cn.com/problems/add-strings/
     */
    public String addStrings(String num1, String num2) {
        StringBuilder res = new StringBuilder();

        int carry = 0;

        int i = num1.length() - 1;
        int j = num2.length() - 1;

        while (i >= 0 || j >= 0 || carry == 1) {
            int cur1 = i >= 0 ? num1.charAt(i) - '0' : 0;
            int cur2 = j >= 0 ? num2.charAt(j) - '0' : 0;

            int cur = cur1 + cur2 + carry;
            if (cur >= 10) {
                carry = 1;
                cur = cur % 10;
            } else {
                carry = 0;
            }
            res.insert(0, cur);
            i--;
            j--;
        }
        return res.toString();
    }

    public static void main(String[] args) {
        AddStrings add = new AddStrings();

        String str1 = "11";
        String str2 = "123";
        String res = add.addStrings(str1, str2);
        System.out.println(res);
    }
}
