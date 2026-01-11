import java.util.Objects;
import java.util.Stack;

class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for (String token: tokens ) {
            if (Objects.equals(token, "+")) {
                stack.push(stack.pop() + stack.pop());
            } else if (Objects.equals(token, "-")) {
                int second = stack.pop();
                int first = stack.pop();
                stack.push(first - second);
            } else if (Objects.equals(token, "*")) {
                stack.push(stack.pop() * stack.pop());

            } else if (Objects.equals(token, "/")) {
                int denominator = stack.pop();
                int numerator = stack.pop();
                stack.push(numerator / denominator);

            } else {
                stack.push(Integer.parseInt(token));
            }
        }

        return stack.pop();
    }
}