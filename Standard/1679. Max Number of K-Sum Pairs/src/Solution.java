import java.util.HashMap;

class Solution {
    public int maxOperations(int[] nums, int k) {
        int count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            int target = k - num;

            if (map.containsKey(target) && map.get(target) > 0) {
                map.put(target, map.get(target) - 1);
                count++;
            } else {
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.maxOperations(new int[]{3,1,3,4,3}, 6));
    }
}