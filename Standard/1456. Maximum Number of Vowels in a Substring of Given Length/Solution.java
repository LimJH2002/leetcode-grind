class Solution {
    public int maxVowels(String s, int k) {
        String vowels = "aeiou";
        int max = 0;
        int currentMax = 0;

        for (int i = 0; i < k; i++) {
            if (vowels.indexOf(s.charAt(i)) >= 0) {
                currentMax++;
            }
        }

        max = currentMax;

        for (int i = k; i < s.length(); i++) {
            if (vowels.indexOf(s.charAt(i)) >= 0) {
                currentMax++;
            }
            if (vowels.indexOf(s.charAt(i - k)) >= 0) {
                currentMax--;
            }

            max = Math.max(max, currentMax);
        }

        return max;
    }
}