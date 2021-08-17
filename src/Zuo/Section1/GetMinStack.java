package Zuo.Section1;

import java.util.Stack;

/**
 * 题目:
 *  设计一个特殊的栈，在实现栈的基础之上，再实现返回栈中最小元素的操作
 * 要求:
 *  1. pop、push、getMin操作的时间复杂度都是O(1)
 *  2. 可使用现有的栈结构
 */
public class GetMinStack {
    private Stack<Integer> dataStack;
    private Stack<Integer> minStack;

    public GetMinStack() {
        dataStack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int num) {
        dataStack.push(num);

        if (minStack.isEmpty()) {
            minStack.push(num);
        } else if (num < getMin()) {
            minStack.push(num);
        }
    }

    public Integer pop() throws Exception {
        if (dataStack.isEmpty()) {
            throw new Exception("无数据");
        }
        Integer res = dataStack.pop();
        if (getMin().equals(res)) {
            minStack.pop();
        }
        return res;
    }

    public Integer getMin() {
        return minStack.peek();
    }
}
