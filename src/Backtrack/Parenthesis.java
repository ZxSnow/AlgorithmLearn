package Backtrack;

import javafx.scene.Parent;

import java.util.ArrayList;
import java.util.List;

public class Parenthesis {
    /**
     * 生成括号
     * 题目描述：
     * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
     * https://leetcode-cn.com/leetbook/read/top-interview-questions-medium/xv33m7/
     */
    public List<String> generateParenthesis(int n) {
        if (n == 0) {
            return new ArrayList();
        }
        List<String> res = new ArrayList<>();
        cnt = n;
        List<String> choices = new ArrayList<>();
        choices.add("(");
        choices.add(")");
        help(choices, new ArrayList<>(), res, 0, 0);
        return res;
    }

    int cnt = 0;

    public void help(List<String> choices, List<String> path, List<String> res, int left, int right) {
        if (path.size() == cnt * 2) {
            StringBuilder sb = new StringBuilder();
            for (String s : path) {
                sb.append(s);
            }
            res.add(sb.toString());
            return;
        }
        for (String choice : choices) {
            int idx;
            if (choice.equals("(")) {
                if (left >= cnt) {
                    continue;
                }
                path.add(choice);
                idx = path.size();
                help(choices, path, res, left + 1, right);
            } else {
                if (right >= left) {
                    continue;
                }
                path.add(choice);
                idx = path.size();
                help(choices, path, res, left, right + 1);
            }
            path.remove(idx - 1);
        }
    }

    public static void main(String[] args) {
        Parenthesis p = new Parenthesis();
        List<String> res = p.generateParenthesis(0);
        System.out.println(res);
    }
}
