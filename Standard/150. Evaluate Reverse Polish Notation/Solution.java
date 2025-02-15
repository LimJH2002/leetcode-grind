import java.util.Stack;
import java.util.function.BiFunction;

class Solution {
  public int evalRPN(String[] tokens) {
    Stack<Integer> stack = new Stack<>();

    for (String token : tokens) {
      switch (token) {
        case "+":
          stack.push(stack.pop() + stack.pop());
          break;
        case "-":
          stack.push(-stack.pop() + stack.pop());
          break;
        case "*":
          stack.push(stack.pop() * stack.pop());
          break;
        case "/":
          int b = stack.pop();
          int a = stack.pop();
          stack.push(a / b);
          break;
        default:
          stack.push(Integer.parseInt(token));
          break;
      }
    }

    return stack.pop();
  }
}