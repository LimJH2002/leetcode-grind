class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int small = 0;
        int big = numbers.length - 1;
        int sum = numbers[small] + numbers[big];

        while (sum != target) {
            if (sum < target) {
                small++;
            } else {
                big--;
            }
            sum = numbers[small] + numbers[big];
        }

        return new int[] {small + 1, big + 1};
    }
}