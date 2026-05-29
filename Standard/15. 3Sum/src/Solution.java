import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            int current = nums[i];
            int pointerA = i + 1;
            int pointerB = nums.length - 1;

            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            while (pointerA < pointerB) {
                int target = -current;
                int tempSum = nums[pointerA] + nums[pointerB];

                if (tempSum < target) {
                    pointerA++;
                } else if (tempSum > target) {
                    pointerB--;
                } else {
                    result.add(Arrays.asList(current, nums[pointerA], nums[pointerB]));
                    pointerA++;
                    while (nums[pointerA] == nums[pointerA - 1] && pointerA < pointerB) {
                        pointerA++;
                    }
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.threeSum(new int[] {0, 0, 0, 0, 0}));
    }
}