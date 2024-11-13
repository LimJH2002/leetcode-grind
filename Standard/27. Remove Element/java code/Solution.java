class Solution {
  public int removeElement(int[] nums, int val) {
    int count = 0;
    int current = 0;
    int checker = 0;

    for (int i = 0; i < nums.length; i++) {
      if (nums[i] == val) {
        checker++;
      } else {
        nums[current++] = nums[checker++];
        count++;
      }
    }

    return count;
  }
}