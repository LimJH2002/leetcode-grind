class Solution {
    public int pivotIndex(int[] nums) {
        int pivot = 0;
        int leftSum = 0;
        int rightSum = 0;

        for (int i = 1; i < nums.length; i++) {
            rightSum += nums[i];
        }

        for (int i = 0; i < nums.length - 1; i++) {
            if (leftSum == rightSum) {
                return pivot;
            }

            leftSum += nums[pivot];
            rightSum -= nums[++pivot];
        }

        return leftSum == rightSum ? pivot : -1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.pivotIndex(new int[]{-1,-1,0,1,1,0}));
    }
}