import java.util.HashSet;

class Solution {

  public int maximumUniqueSubarray(int[] nums) {
    HashSet<Integer> hashSet = new HashSet<>();
    int left = 0;
    int currTotal = 0;
    int maxTotal = 0;

    for (int right = 0; right < nums.length; right++) {
      int curr = nums[right];

      while (hashSet.contains(curr)) {
        currTotal -= nums[left];
        hashSet.remove(nums[left]);
        left++;
      }

      hashSet.add(curr);
      currTotal += curr;

      maxTotal = Math.max(currTotal, maxTotal);
    }

    return maxTotal;
  }
}