class Solution {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int remaining = fruits.length;

        for (int i = 0; i < fruits.length; i++) {
            for (int j = 0; j < baskets.length; j++) {
                if (fruits[i] <= baskets[j]) {
                    remaining--;
                    baskets[j] = 0;
                    break;
                }
            }
        }

        return remaining;
    }
}