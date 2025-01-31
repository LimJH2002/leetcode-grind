import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> summaryRanges(int[] nums) {
        ArrayList<String> res = new ArrayList<>();
        if (nums.length == 0) return res;

        int start = 0;  // Start of current range

        for (int i = 1; i <= nums.length; i++) {
            if (i == nums.length || nums[i] != nums[i-1] + 1) {
                if (start == i-1) {
                    res.add(String.valueOf(nums[start]));
                } else {
                    res.add(nums[start] + "->" + nums[i-1]);
                }
                if (i < nums.length) {
                    start = i;
                }
            }
        }

        return res;
    }
}