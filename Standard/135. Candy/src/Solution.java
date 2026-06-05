import java.util.Arrays;

class Solution {
    public int candy(int[] ratings) {
        int[] leftPass = new int[ratings.length];
        int[] rightPass = new int[ratings.length];
        int total = 0;

        Arrays.fill(leftPass, 1);
        Arrays.fill(rightPass, 1);

        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                leftPass[i] = leftPass[i - 1] + 1;
            }
        }

        for (int i = ratings.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                rightPass[i] = rightPass[i + 1] + 1;
            }
        }

        for (int i = 0; i < ratings.length; i++) {
            total += Math.max(leftPass[i], rightPass[i]);
        }

        return total;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.candy(new int[]{1,2,2}));
    }
}