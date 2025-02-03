import java.util.HashSet;

class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer> seen = new HashSet<>();

        while (n != 1 && !seen.contains(n)) {
            seen.add(n);
            n = operation(n);
        }

        return n == 1;
    }

    public int operation(int n) {
        int res = 0;

        while (n > 0) {
            int rem = n % 10;
            res += rem * rem;
            n /= 10;
        }

        return res;
    }
}