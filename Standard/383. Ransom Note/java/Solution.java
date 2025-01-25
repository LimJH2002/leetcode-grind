import java.util.HashMap;

class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character, Integer> hashset = new HashMap<>();

        for (int i = 0; i < magazine.length(); i++) {
            char c = magazine.charAt(i);
            int count = hashset.get(c) == null ? 0 : hashset.get(c);
            hashset.put(magazine.charAt(i), count + 1);
        }

        for (int i = 0; i < ransomNote.length(); i++) {
            char c = ransomNote.charAt(i);
            boolean contains = hashset.containsKey(c);

            if (!contains || hashset.get(c) <= 0) {
                return false;
            } else {
                hashset.put(c, hashset.get(c) - 1);
            }
        }

        return true;
    }
}