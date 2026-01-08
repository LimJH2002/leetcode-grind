import java.util.HashMap;

class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] result = new int[nums.length];
        HashMap<Integer, Integer> memoized = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int currentNumber = nums[i];

            if (memoized.containsKey(currentNumber)) {
                result[i] = memoized.get(currentNumber);
                continue;
            }

            int runningCount = 0;
            for (int j = 0; j < nums.length; j++) {
                if (currentNumber > nums[j]) {
                    runningCount++;
                }
            }

            result[i] = runningCount;
            memoized.put(currentNumber, runningCount);
        }

        return result;
    }
}