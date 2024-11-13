class Solution {
  public static int removeDuplicates(int[] nums) {
    int currentInt = nums[0];
    int occurences = 1;
    int k = 1;

    for (int i = 1; i < nums.length; i++) {
      if (nums[i] == currentInt && occurences >= 2) {
        continue;
      } else if (nums[i] == currentInt) {
        nums[k++] = nums[i];
        occurences++;
      } else {
        currentInt = nums[i];
        nums[k++] = nums[i];
        occurences = 1;
      }
    }

    return k;
  }
}