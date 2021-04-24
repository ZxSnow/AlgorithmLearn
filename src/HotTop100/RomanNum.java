package HotTop100;

import java.util.HashMap;
import java.util.Map;

public class RomanNum {

    int[] nums = {1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};
    String[] romans = {"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"};

    public String intToRoman(int num) {
        StringBuilder res = new StringBuilder();
        for (int i = nums.length - 1; i >= 0; i--) {
            if (num < nums[i]) {
                continue;
            }
            romanMerge(num / nums[i], i, res);
            num = num % nums[i];
        }
        return res.toString();
    }

    public void romanMerge(int time, int index, StringBuilder sb) {
        for (int i = 0; i < time; i++) {
            sb.append(romans[index]);
        }
    }

    public int romanToInt(String s) {
        int res = 0;
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(romans[i], nums[i]);
        }
        int i = 0;
        String key = "";
        while (i < s.length()) {
            char c = s.charAt(i);
            key = c + "";
            if (i + 1 < s.length()) {
                char next = s.charAt(i + 1);
                if (map.get(next + "") > map.get(c + "")) {
                    key = c + "" + next;
                    i++;
                }
            }
            res += map.get(key);
            i++;
        }
        return res;
    }

    public static void main(String[] args) {
        RomanNum rn = new RomanNum();
        String res = rn.intToRoman(1994);
        int num = rn.romanToInt("MCMXCIV");
        System.out.println(num);
    }
}
