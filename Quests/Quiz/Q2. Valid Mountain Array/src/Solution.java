class Solution {
    public boolean validMountainArray(int[] arr) {
        if (arr.length < 3) return false;

        boolean seenIncreasing = false;
        boolean seenDecreasing = false;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == arr[i - 1]) {
                return false;
            }

            if (arr[i] > arr[i - 1]) {
                if (seenDecreasing) return false;
                seenIncreasing = true;
            } else if (arr[i] < arr[i - 1]) {
                if (!seenIncreasing) return false;
                seenDecreasing = true;
            }
        }

        return seenIncreasing && seenDecreasing;
    }
}