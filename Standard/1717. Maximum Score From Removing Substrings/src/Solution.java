import java.util.Stack;

class Solution {
    public int maximumGain(String s, int x, int y) {
        if (y > x) {
            return maximumGain(new StringBuilder(s).reverse().toString(), y, x);
        }

        Stack<Character> stack = new Stack<>();
        int total = 0;

        for (char c : s.toCharArray()) {
            if (!stack.isEmpty() && stack.peek() == 'a' && c == 'b') {
                stack.pop();
                total += x;
            } else {
                stack.push(c);
            }
        }

        StringBuilder remaining = new StringBuilder();
        for (char c : stack) {
            remaining.append(c);
        }

        stack.clear();
        for (char c : remaining.toString().toCharArray()) {
            if (!stack.isEmpty() && stack.peek() == 'b' && c == 'a') {
                stack.pop();
                total += y;
            } else {
                stack.push(c);
            }
        }


        return total;
    }
}