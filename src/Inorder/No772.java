package Inorder;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class No772 {
    public int calculate(String s) {
        // 规定一下优先级
        Map<Character, Integer> prio = new HashMap<>();
        prio.put('(', 1);
        prio.put('+', 2);
        prio.put('-', 2);
        prio.put('*', 3);
        prio.put('/', 3);

        Stack<Character> ops = new Stack<>();
        Stack<Long> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                ops.add('(');
            } else if (Character.isDigit(ch)) {
                // 截取出数字然后入栈
                int j = i;
                while (j < s.length() && Character.isDigit(s.charAt(j))) {
                    j++;
                }

                stack.push(Long.parseLong(s.substring(i, j)));
                // 别忘了移动i指针
                i = j - 1;
            } else if (ch == ')') {
                while (ops.peek() != '(') {
                    calc(stack, ops);
                }
                ops.pop();
            } else if (ch != ' ') {
                while (!ops.isEmpty() && prio.get(ops.peek()) >= prio.get(ch)) {
                    calc(stack, ops);
                }
                ops.push(ch);
            }
        }

        while (stack.size() > 1) {
            calc(stack, ops);
        }

        long res = stack.peek();
        return (int) res;
    }

    private void calc(Stack<Long> stack, Stack<Character> ops) {
        long n2 = stack.pop(), n1 = stack.pop();
        switch (ops.pop()) {
            case '+':
                stack.push(n1 + n2);
                break;
            case '-':
                stack.push(n1 - n2);
                break;
            case '*':
                stack.push(n1 * n2);
                break;
            case '/':
                stack.push(n1 / n2);
                break;
        }
    }

    public static void main(String[] args) {
        String s = "(10+8)*2";
        No772 no = new No772();
        int res = no.calculate(s);
        System.out.println(res);
    }
}
