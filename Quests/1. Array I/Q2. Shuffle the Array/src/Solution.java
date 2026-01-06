class Solution {
    public int[] shuffle(int[] nums, int n) {
        int[] result = new int[nums.length];
        int current = 0;
        int iteration = 0;

        while (current < nums.length) {
            result[current++] = nums[iteration];
            result[current++] = nums[iteration++ + n];
        }

        return result;
    }
}