package Trick;

import java.util.Stack;

public class TwoStackQueue {

    public static void main(String[] args) {
        CQueue queue = new CQueue();
        queue.appendTail(1);
        queue.appendTail(2);
        queue.appendTail(3);
        queue.appendTail(4);

        int re = queue.deleteHead();
        queue.appendTail(5);

        System.out.println(re);
    }
}

class CQueue {

    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();

    public CQueue() {
    }

    public void appendTail(int value) {
        stack1.add(value);
    }

    public int deleteHead() {
        if (!stack2.isEmpty()) {
            return stack2.pop();
        } else {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
            return stack2.isEmpty() ? -1 : stack2.pop();
        }
    }
}