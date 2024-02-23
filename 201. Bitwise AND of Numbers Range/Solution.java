class Solution {
    public int rangeBitwiseAnd(int left, int right) {
        if (left == right) {
            return left;
        }

        StringBuilder leftBinary = new StringBuilder(Integer.toBinaryString(left));
        StringBuilder rightBinary = new StringBuilder(Integer.toBinaryString(right));
        StringBuilder sb = new StringBuilder();
        int current = 33;

        // Make both into 32 bits
        while (leftBinary.length() < 32) {
            leftBinary.insert(0, "0");
        }

        while (rightBinary.length() < 32) {
            rightBinary.insert(0, "0");
        }

        for (int i = 0; i < leftBinary.length(); i++) {
            current--;
            if (leftBinary.charAt(i) == rightBinary.charAt(i)) {
                sb.append(leftBinary.charAt(i));
            } else {
                break;
            }
        }

        sb.append("0".repeat(current));

        return Integer.parseInt(sb.toString(), 2);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int left = 1;
        int right = 1;
        int res = solution.rangeBitwiseAnd(left, right);
        System.out.println(res);
    }
}