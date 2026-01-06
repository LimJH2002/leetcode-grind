class Solution {
    public int[] getConcatenation(int[] nums) {
        int[] result = new int[nums.length * 2];

        for (int i = 0; i < nums.length; i++) {
            int number = nums[i];
            result[i] = number;
            result[i + nums.length] = number;
        }

        return result;
    }
}