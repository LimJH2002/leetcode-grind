class Solution {
    public int longestSubarray(int[] nums) {
        int left = 0;
        int right = 0;
        int max = 0;
        int zeros = 0;

        while (right < nums.length) {
            if (nums[right] == 0) {
                zeros++;
            }

            if (zeros > 1) {
                while (zeros > 1) {
                    if (nums[left] == 0) {
                        zeros--;
                    }
                    left++;
                }
            }

            max = Math.max(max, right - left);
            right++;
        }

        return max;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.longestSubarray(new int[] {1,1,0,0,1,1,1,0,1}));
    }
}