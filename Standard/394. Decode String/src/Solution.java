import java.util.Stack;

class Solution {
    public String decodeString(String s) {
        Stack<String> stringStack = new Stack<>();
        Stack<Integer> countStack = new Stack<>();
        StringBuilder currentString = new StringBuilder();
        int currentCount = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (Character.isDigit(c)) {
                currentCount = currentCount * 10 + (c - '0');
            }

            if (c == '[') {
                stringStack.push(currentString.toString());
                countStack.push(currentCount);
                currentString.setLength(0);
                currentCount = 0;
            }

            if (Character.isAlphabetic(c)) {
                currentString.append(c);
            }

            if (c == ']') {
                currentString = new StringBuilder(stringStack.pop()).append(currentString.toString().repeat(countStack.pop()));
            }
        }

        return currentString.toString();
    }
}