package Zuo.Section1;

import java.util.Stack;

/**
 * 只是用递归函数实现逆序一个栈
 */
public class RecursiveStack {
    /**
     * 将stack的栈底元素返回并移除（辅助方法）
     *
     * @param stack
     * @return
     */
    public int getAndRemoveLastElement(Stack<Integer> stack) {
        int res = stack.pop();
        if (stack.isEmpty()) {
            return res;
        }
        int last = getAndRemoveLastElement(stack);
        stack.push(res);
        return last;
    }

    /**
     * 逆序
     *
     * @param stack
     */
    public void reverse(Stack<Integer> stack) {
        if (stack.isEmpty())
            return;
        int i = getAndRemoveLastElement(stack);
        reverse(stack);
        stack.push(i);
    }
}
