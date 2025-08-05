import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;


class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        HashSet<Integer> nums1exists = new HashSet<>();
        HashSet<Integer> nums2exists = new HashSet<>();
        List<List<Integer>> output = new ArrayList<>();

        for (int num : nums1) {
            nums1exists.add(num);
        }

        for (int num : nums2) {
            nums2exists.add(num);
        }

        HashSet<Integer> copy = new HashSet<>(nums1exists);
        nums1exists.removeAll(nums2exists);
        nums2exists.removeAll(copy);

        output.add(nums1exists.stream().toList());
        output.add(nums2exists.stream().toList());

        return output;
    }
}