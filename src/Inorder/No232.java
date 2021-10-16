package Inorder;

import java.util.Stack;

public class No232 {
    public static void main(String[] args) {
        MyQueue queue = new MyQueue();
        queue.push(1);
        queue.push(2);
        queue.push(3);
        queue.push(4);

        queue.pop();
        System.out.println(queue.peek());
        queue.pop();
    }
}

class MyQueue {
    private Stack<Integer> in = new Stack<>();
    private Stack<Integer> out = new Stack<>();
    private int size = 0;

    public MyQueue() {

    }

    public void push(int x) {
        in.add(x);
        size++;
    }

    public int pop() {
        checkOut();
        int res = out.pop();
        size--;
        return res;
    }

    private void checkOut() {
        if (out.isEmpty()) {
            while (!in.isEmpty()) {
                out.push(in.pop());
            }
        }
    }

    public int peek() {
        checkOut();
        return out.peek();
    }

    public boolean empty() {
        return size == 0;
    }
}
