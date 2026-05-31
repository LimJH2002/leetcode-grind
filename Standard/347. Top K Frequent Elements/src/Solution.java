import java.util.*;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> frequencies = new HashMap<>();
        ArrayList<Integer>[] buckets = new ArrayList[nums.length + 1];
        int[] result = new int[k];

        for (int num : nums) {
            frequencies.put(num, frequencies.getOrDefault(num, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : frequencies.entrySet()) {
            int freq = entry.getValue();
            if (buckets[freq] == null) {
                buckets[freq] = new ArrayList<>();
            }
            buckets[freq].add(entry.getKey());
        }

        int count = 0;
        int pointer = buckets.length - 1;
        while (count < k && pointer >= 0) {
            if (buckets[pointer] != null) {
                ArrayList<Integer> candidates = buckets[pointer];
                for (int num : candidates) {
                    result[count++] = num;
                }
            }
            pointer--;
        }

        return result;
    }
}