import java.util.*;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, Integer> mappings = new HashMap<>();
        List<List<String>> result = new ArrayList<>();

        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String sorted = new String(chars);

            if (mappings.containsKey(sorted)) {
                int index = mappings.get(sorted);
                result.get(index).add(str);

            } else {
                List<String> group = new ArrayList<>();
                group.add(str);
                result.add(group);
                mappings.put(sorted, result.size() - 1);
            }
        }

        return result;
    }
}