import java.util.Arrays;

class Solution {
    public int[][] merge(int[][] intervals) {
        int[][] results = new int[intervals.length][2];
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        int pointer = 0;
        results[0] = intervals[0];

        for (int i = 1; i < intervals.length; i++) {
            int[] interval = intervals[i];
            int start = results[pointer][0];
            int end = results[pointer][1];
            int newStart = interval[0];
            int newEnd = interval[1];

            if (newStart > end) {
                pointer++;
                results[pointer] = new int[] {newStart, newEnd};
            } else {
                int[] newInterval = {start, Math.max(end, newEnd)};
                results[pointer] = newInterval;
            }
        }

        return Arrays.copyOfRange(results, 0, pointer + 1);
    }
}