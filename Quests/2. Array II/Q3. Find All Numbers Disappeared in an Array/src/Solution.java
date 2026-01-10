import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            set.add(i + 1);
        }

        for (int num : nums) {
            set.remove(num);
        }

        return new ArrayList<Integer>(set);
    }
}