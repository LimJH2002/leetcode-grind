class SolutionNaive {
    public int maxOperations(int[] nums, int k) {
        int res = 0;

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == k) {
                    nums[i] = Integer.MAX_VALUE;
                    nums[j] = Integer.MAX_VALUE;
                    res++;
                }
            }
        }

        return res;
    }
}