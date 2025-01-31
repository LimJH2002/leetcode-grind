import java.util.HashMap;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hashmap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int key = target - nums[i];
            if (hashmap.containsKey(nums[i])) {
                return new int[] {hashmap.get(nums[i]), i};
            } else {
                hashmap.put(key, i);
            }
        }

        return null;
    }
}