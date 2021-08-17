package Zuo.Section1;

import java.util.Stack;

/**
 * 题目:
 * 编写一个类，用两个栈实现队列，支持队列的基本操作，(add,poll,peek)
 */
public class TwoStackQueue<T> {
    public Stack<T> pushStack;
    public Stack<T> popStack;

    public TwoStackQueue() {
        pushStack = new Stack<>();
        popStack = new Stack<>();
    }

    public void add(T value) {
        pushStack.push(value);
    }

    public T poll() throws Exception {
        if (popStack.isEmpty() && pushStack.isEmpty()) {
            throw new Exception("No data");
        }
        if (popStack.isEmpty()) {
            while (!pushStack.isEmpty()) {
                popStack.push(pushStack.pop());
            }
        }
        return popStack.pop();
    }

    public T peek() throws Exception {
        if (popStack.isEmpty() && pushStack.isEmpty()) {
            throw new Exception("No data");
        }
        if (popStack.isEmpty()) {
            while (!pushStack.isEmpty()) {
                popStack.push(pushStack.pop());
            }
        }
        return popStack.peek();
    }
}
