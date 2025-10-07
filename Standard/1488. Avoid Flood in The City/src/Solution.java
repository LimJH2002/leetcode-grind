import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

class Solution {
    public int[] avoidFlood(int[] rains) {
        int n = rains.length;
        int[] ans = new int[n];
        Map<Integer, Integer> fullLakes = new HashMap<>(); // lake -> day it became full
        TreeSet<Integer> dryDays = new TreeSet<>(); // available dry days

        for (int i = 0; i < n; i++) {
            if (rains[i] > 0) {
                int lake = rains[i];

                // If lake is already full, we need to have dried it before
                if (fullLakes.containsKey(lake)) {
                    // Find a dry day between when it became full and now
                    Integer dryDay = dryDays.ceiling(fullLakes.get(lake));

                    if (dryDay == null) {
                        return new int[0]; // Impossible
                    }

                    ans[dryDay] = lake; // Use this dry day to dry this lake
                    dryDays.remove(dryDay);
                }

                fullLakes.put(lake, i); // Lake becomes/stays full
                ans[i] = -1;

            } else {
                // Dry day - save it for later use
                dryDays.add(i);
            }
        }

        // Fill remaining dry days with any valid lake (e.g., 1)
        for (int day : dryDays) {
            ans[day] = 1;
        }

        return ans;
    }
}