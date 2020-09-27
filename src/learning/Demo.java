package learning;

import java.util.Stack;
import java.util.Vector;

public class Demo {
    public static void main(String[] args) {

    }

    public Vector<Integer> nextElement(Vector<Integer> nums) {
        Vector<Integer> ans = new Vector<>();
        Stack<Integer> stack = new Stack<>();
        for (int i = nums.size() - 1; i >= 0; i--) {
            while (!stack.empty() && nums.get(stack.peek()) <= nums.get(i)) {
                stack.pop();
            }
            ans.set(i, stack.empty() ? 0 : stack.peek() - i);
            stack.add(i);
        }
        return ans;
    }
}
