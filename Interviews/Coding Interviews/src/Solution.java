import java.util.Arrays;

public class Solution {
    public int[] productExceptSelf(int[] arr) {
        int[] output = new int[arr.length];

        // Left product
        for (int i = 0; i < arr.length; i++) {
            if (i > 0) {
                output[i] = output[i - 1] * arr[i - 1];
            } else {
                output[i] = 1;
            }
        }

        // Right product
        int runningTotal = 1;
        for (int i = arr.length - 2; i >= 0; i--) {
            runningTotal *= arr[i + 1];
            output[i] = output[i] * runningTotal;
        }


        return output;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(Arrays.toString(sol.productExceptSelf(new int[]{5, 2, 3})));
    }

}
