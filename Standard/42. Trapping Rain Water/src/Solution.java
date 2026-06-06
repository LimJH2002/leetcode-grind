import java.util.Arrays;

class Solution {
    public int trap(int[] height) {
        int[] leftPass = new int[height.length];
        int[] rightPass = new int[height.length];
        int totalWater = 0;

        int highestLeft = height[0];
        for (int i = 1; i < height.length; i++) {
            leftPass[i] = highestLeft;
            highestLeft = Math.max(highestLeft, height[i]);
        }

        int highestRight = height[height.length - 1];
        for (int i = height.length - 2; i >= 0; i--) {
            rightPass[i] = highestRight;
            highestRight = Math.max(highestRight, height[i]);
        }

        for (int i = 0; i < height.length; i++) {
            int water = Math.min(leftPass[i], rightPass[i]) - height[i];
            if (water > 0) {
                totalWater += water;
            }
        }

        return totalWater;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.trap(new int[] {0,1,0,2,1,0,1,3,2,1,2,1}));
    }
}