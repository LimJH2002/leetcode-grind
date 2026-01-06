class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int currentMax = 0;
        int runningMax = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                runningMax++;
            } else {
                currentMax = Math.max(currentMax, runningMax);
                runningMax = 0;
            }
        }

        currentMax = Math.max(currentMax, runningMax);
        return currentMax;
    }
}