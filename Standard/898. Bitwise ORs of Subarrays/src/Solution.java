import java.util.HashSet;
import java.util.Set;

class Solution {
    public int subarrayBitwiseORs(int[] arr) {
        Set<Integer> master = new HashSet<>();
        Set<Integer> prev = new HashSet<>();

        for (int i = 0; i < arr.length; i++) {
            Set<Integer> curr = new HashSet<>();
            curr.add(arr[i]);

            for (int element : prev) {
                curr.add(arr[i] | element);
            }
            master.addAll(curr);
            prev = curr;
        }

        return master.size();
    }
}