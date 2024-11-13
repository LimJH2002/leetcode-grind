class Solution {
  public int removeDuplicates(int[] nums) {
    int count = 1;
    int previous = nums[0];
    int pointer = 1;

    for (int i = 1; i < nums.length; i++) {
      if (nums[i] == previous) {
        continue;
      } else {
        nums[pointer++] = nums[i];
        previous = nums[i];
        count++;
      }
    }
    return count;
  }
}