class Solution {
  public void rotate(int[] nums, int k) {
    int cutoff = k % nums.length;
    reverse(0, nums.length - 1, nums);
    reverse(0, cutoff - 1, nums);
    reverse(cutoff, nums.length - 1, nums);
  }

  public void reverse(int start, int end, int[] nums) {
    while (start < end) {
      int temp = nums[start];
      nums[start] = nums[end];
      nums[end] = temp;
      start++;
      end--;
    }
  }
}