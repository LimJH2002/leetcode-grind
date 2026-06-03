import java.util.Arrays;

class Solution {
    int[] robHistory;

    public int rob(int[] nums) {
        robHistory = new int[nums.length];
        Arrays.fill(robHistory, -1);

        return Math.max(robHelper(nums, 0), robHelper(nums, 1));
    }

    private int robHelper(int[]nums, int targetHouse) {
        if (targetHouse >= nums.length) {
            return 0;
        }

        if (robHistory[targetHouse] != -1) {
            return robHistory[targetHouse];
        } else {
            int bestOutcome = Math.max(robHelper(nums, targetHouse + 2),
                                       robHelper(nums, targetHouse + 3));
            int result = nums[targetHouse] + bestOutcome;
            robHistory[targetHouse] = result;

            return result;
        }
    }
}