import java.util.HashSet;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int start = 0;
        int end = 0;
        int longest = 0;
        HashSet<Character> charSet = new HashSet<>();

        while (end < s.length()) {
            char newChar = s.charAt(end);
            if (!charSet.contains(newChar)) {
                charSet.add(newChar);
                longest = Math.max(longest, end - start + 1);
                end++;

            } else {
                while(charSet.contains(newChar)) {
                    charSet.remove(s.charAt(start));
                    start++;
                }
            }
        }

        return longest;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.lengthOfLongestSubstring("au"));
    }
}