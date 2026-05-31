import java.util.*;

class SolutionNlogN {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> frequencies = new HashMap<>();
        int[] result = new int[k];

        for (int num : nums) {
            if (frequencies.containsKey(num)) {
                int count = frequencies.get(num);
                frequencies.put(num, count + 1);
            } else {
                frequencies.put(num, 1);
            }
        }

        Set<Map.Entry<Integer, Integer>> entrySet = frequencies.entrySet();
        List<Map.Entry<Integer, Integer>> entryList = new ArrayList<>(entrySet);
        entryList.sort((a, b) -> b.getValue() - a.getValue());

        for (int i = 0; i < k; i++) {
            result[i] = entryList.get(i).getKey();
        }

        return result;
    }
}