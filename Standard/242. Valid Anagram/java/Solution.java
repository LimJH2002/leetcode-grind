import java.util.HashMap;

class Solution {
    public boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> charCount = new HashMap<>();

        if (s.length() != t.length()) {
            return false;
        }

        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            if (charCount.containsKey(currentChar)) {
                charCount.put(currentChar, charCount.get(currentChar) + 1);
            } else {
                charCount.put(currentChar, 1);
            }
        }

        for (int i = 0; i < t.length(); i++) {
            char currentChar = t.charAt(i);

            if (!charCount.containsKey(currentChar)) {
                return false;
            }

            int count = charCount.get(currentChar);

            if (count < 1) {
                return false;
            } else {
                charCount.put(currentChar, count - 1);
            }
        }

        return true;
    }
}