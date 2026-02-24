class Solution {
    public int longestOnes(int[] nums, int k) {
        int left = 0;
        int right = 0;
        int bestScore = 0;
        int zeros = 0;

        while (right < nums.length){
            if (nums[right] == 0) {
                zeros++;
            }

            if (zeros > k) {
                // Traverse left to pass the leftmost 0
                while (zeros > k) {
                    if (nums[left] == 0) {
                        zeros--;
                    }
                    left++;
                }
            }

            bestScore = Math.max(bestScore, right - left + 1);
            right++;
        }

        return bestScore;
    }
}