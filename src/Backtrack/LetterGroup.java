package Backtrack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterGroup {
    /**
     * 电话号码的字母组合
     * https://leetcode-cn.com/leetbook/read/top-interview-questions-medium/xv8ka1/
     */

    List<String> res= new ArrayList<>();;
    Map<Character, String> map = new HashMap<>();
    int cnt = 0;

    public List<String> letterCombinations(String digits) {
        if(digits.length()==0){
            return new ArrayList<>();
        }
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        cnt = digits.length();
//        group(new ArrayList<>(), digits);
        help(new StringBuilder(),digits);
        return res;
    }

    /**
     * @param path   路径
     * @param choice 选择列表
     */
    public void group(List<Character> path, String choice) {
        if (path.size() == cnt) {
            StringBuilder str = new StringBuilder();
            for (Character c : path) {
                str.append(c);
            }
            res.add(str.toString());
            return;
        }

        String cs = map.get(choice.charAt(0));

        for (int i = 0; i < cs.length(); i++) {
            //做选择
            // 不要求不重复
//            if (path.contains(cs.charAt(i))) {
//                continue;
//            }
            path.add(cs.charAt(i));
            int curPath = path.size();

            group(path, choice.substring(1));

            path.remove(curPath - 1);
        }
    }

    public void help(StringBuilder path, String choice) {
        if (cnt == path.length()) {
            String p = path.toString();
            res.add(p);
            return;
        }
        String cs = map.get(choice.charAt(0));
        for (char c : cs.toCharArray()) {
            path.append(c);
            help(path, choice.substring(1));
            int cur = path.length();
            path.deleteCharAt(cur - 1);
        }
    }

    public static void main(String[] args) {
        LetterGroup lg = new LetterGroup();
        List<String> res = lg.letterCombinations("");
        System.out.println(res);
    }
}
