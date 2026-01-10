import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> buildArray(int[] target, int n) {
        ArrayList<String> result = new ArrayList<>();
        int pointer = 0;

        for (int i = 1; i <= n; i++) {
            if (pointer >= target.length) {
                break;
            }

            if (i == target[pointer]) {
                pointer++;
                result.add("Push");
            } else {
                result.add("Push");
                result.add("Pop");
            }
        }

        return result;
    }
}