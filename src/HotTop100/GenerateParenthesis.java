package HotTop100;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {
    public List<String> generateParenthesis(int n) {
        res = new ArrayList<>();
        List<String> choice = new ArrayList<String>();
        choice.add(Parenthesis.LEFT.value);
        choice.add(Parenthesis.RIGHT.value);
        help(new StringBuilder(), choice, n, 0, 0);
        return res;
    }

    List<String> res;

    public void help(StringBuilder path, List<String> choice, int n, int left, int right) {
        if (path.length() == n * 2) {
            String p = path.toString();
            res.add(p);
            return;
        }

        for (String s : choice) {
            int idx;
            if (s.equals(Parenthesis.LEFT.value)) {
                if (left >= n) {
                    continue;
                }
                path.append(s);
                idx = path.length();

                help(path, choice, n, left + 1, right);
            } else {
                if (right >= left) {
                    continue;
                }
                path.append(s);
                idx = path.length();

                help(path, choice, n, left, right + 1);
            }
            path.deleteCharAt(idx - 1);
        }
    }

    public static void main(String[] args) {
        GenerateParenthesis gp = new GenerateParenthesis();
        List<String> res = gp.generateParenthesis(3);
        System.out.println(res);
    }
}


enum Parenthesis {
    LEFT("("),
    RIGHT(")");

    public String value;

    Parenthesis(String value) {
        this.value = value;
    }
}
