class Solution {
    public int romanToInt(String s) {
        int prev = romanValue(s.charAt(0));
        int sum = prev;

        for (int i = 1; i < s.length(); i++) {
            int current = romanValue(s.charAt(i));
            System.out.println("Current " + current);

            if (current > prev) {
                sum += current - prev * 2;
            } else {
                sum += current;
            }

            prev = current;
        }

        return sum;
    }

    private int romanValue(char c) {
        return switch (c) {
            case 'I' -> 1;
            case 'V' -> 5;
            case 'X' -> 10;
            case 'L' -> 50;
            case 'C' -> 100;
            case 'D' -> 500;
            case 'M' -> 1000;
            default -> 0;
        };
    }

}