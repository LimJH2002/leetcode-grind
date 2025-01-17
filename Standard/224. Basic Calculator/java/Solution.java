import java.util.Stack;

class Solution {
    public int calculate(String s) {
        int res = 0;
        int num = 0;
        int sign = 1;
        Stack<Integer> numStack = new Stack<>();
        Stack<Integer> signStack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            if (curr == ' ') {
                continue;
            } else if (curr == '+' || curr == '-') {
                res += sign * num;
                num = 0;
                if (curr == '+') {
                    sign = 1;
                } else {
                    sign = -1;
                }
            } else if (curr == '(') {
                numStack.push(res);
                signStack.push(sign);
                res = 0;
                sign = 1;
            } else if (curr == ')') {
                res += sign * num;
                num = 0;
                res = res * signStack.pop() + numStack.pop();
            } else {
                num = num * 10 + (curr - '0');
            }
        }

        res += sign * num;
        return res;
    }
}