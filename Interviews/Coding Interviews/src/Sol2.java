import java.util.HashSet;

public class Sol2 {
    public int longestUniqueSubstring(String str) {
        int left = 0, right = 0, maxLength = 0;
        HashSet<Character> hashset = new HashSet<>();

        while (right < str.length()) {
            char currentCharacter = str.charAt(right);

            if (hashset.contains(currentCharacter)) {
                maxLength = Math.max(maxLength, right - left);

                while (hashset.contains(currentCharacter)) {
                    hashset.remove(str.charAt(left));
                    left++;
                }

                hashset.add(currentCharacter);
            } else {
                hashset.add(currentCharacter);
            }
            right++;
        }

        return Math.max(maxLength, right - left);
    }

    public static void main(String[] args) {
        Sol2 sol = new Sol2();
        System.out.println(sol.longestUniqueSubstring("abcdefghijklmnopqrstuvwxyz a"));
    }
}
