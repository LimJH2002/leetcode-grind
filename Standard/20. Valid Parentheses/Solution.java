import java.util.Stack;

class Solution {
  public boolean isValid(String s) {
    Stack<Character> stack = new Stack<>();

    for (int i = 0; i < s.length(); i++) {
      Character character = s.charAt(i);

      if (character == ')') {
        if (stack.isEmpty() || stack.peek() != '(') {
          return false;
        } else {
          stack.pop();
        }
      } else if (character == '}' ) {
        if (stack.isEmpty() || stack.peek() != '{') {
          return false;
        } else {
          stack.pop();
        }
      } else if (character == ']') {
        if (stack.isEmpty() || stack.peek() != '[') {
          return false;
        } else {
          stack.pop();
        }
      } else {
        stack.push(character);
      }
    }
    return stack.isEmpty();
  }
}