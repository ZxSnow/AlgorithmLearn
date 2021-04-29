package HotTop100;

import java.util.Stack;

public class Brackets {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (stack.size() == 0) {
                    return false;
                }
                Character pair = getPair(stack.peek());
                if (pair == null) return false;
                if (pair != c) {
                    return false;
                } else {
                    stack.pop();
                }
            }
        }
        return stack.size() == 0;
    }

    public Character getPair(Character c) {
        if (c == null) return null;
        if (c == '(') return ')';
        if (c == '{') return '}';
        return ']';
    }

    public static void main(String[] args) {
        Brackets b = new Brackets();
        String s = "]";
        boolean res = b.isValid(s);
        System.out.println(res);
    }
}
