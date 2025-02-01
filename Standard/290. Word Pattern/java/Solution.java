import java.util.HashMap;

class Solution {
    public boolean wordPattern(String pattern, String s) {
        HashMap<Character, String> wordMap = new HashMap<>();
        HashMap<String, Character> charMap = new HashMap<>();
        String[] strArray = s.split(" ");

        if (pattern.length() != strArray.length) {
            return false;
        }

        for (int i = 0; i < strArray.length; i++) {
            char current = pattern.charAt(i);
            String currentStr = strArray[i];

            if (wordMap.containsKey(current) || charMap.containsKey(currentStr)) {
                if (charMap.containsKey(currentStr) && charMap.get(currentStr) != current) {
                    return false;
                }

                if (!wordMap.get(current).equals(currentStr)) {
                    return false;
                }
            } else {
                wordMap.put(current, currentStr);
                charMap.put(currentStr, current);
            }
        }

        return true;
    }
}