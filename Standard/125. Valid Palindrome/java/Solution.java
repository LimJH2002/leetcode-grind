class Solution {
    public boolean isPalindrome(String s) {
        int leftPointer = 0;
        int rightPointer = s.length() - 1;
        char char1 = ' ';
        char char2 = ' ';

        while (leftPointer < rightPointer) {
            char1 = s.charAt(leftPointer);
            char2 = s.charAt(rightPointer);

            if (!Character.isLetter(char1) && !Character.isDigit(char1)) {
                leftPointer++;
                continue;
            }

            if (!Character.isLetter(char2) && !Character.isDigit(char2)) {
                rightPointer--;
                continue;
            }

            if (Character.toLowerCase(char1) != Character.toLowerCase(char2)) {
                return false;
            } else {
                leftPointer++;
                rightPointer--;
            }
        }

        return true;
    }
}