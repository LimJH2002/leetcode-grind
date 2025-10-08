import java.util.Arrays;

class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int spellsLength = spells.length;
        int[] output = new int[spellsLength];
        Arrays.sort(potions);

        for (int i = 0; i < spellsLength; i++) {
            int minIndex = smallestPosition(spells[i], potions, success, 0, potions.length - 1);
            output[i] = potions.length - minIndex;
        }

        return output;
    }

    private int smallestPosition(int spell, int[] potions, long success, int left, int right) {
        if (left > right) {
            return potions.length;  // No valid potion found
        }

        int mid = left + (right - left) / 2;
        long result = (long) spell * potions[mid];

        if (result >= success) {
            // This potion works, but check if there's a smaller one
            if (mid == 0 || (long) spell * potions[mid - 1] < success) {
                return mid;  // This is the smallest working potion
            }
            return smallestPosition(spell, potions, success, left, mid - 1);
        } else {
            // This potion doesn't work, search right
            return smallestPosition(spell, potions, success, mid + 1, right);
        }
    }

    public static void main(String[] args) {
        int[] spells = new int[]{1,2,3,4,5,6,7};
        int[] potions = new int[]{1,2,3,4,5,6,7};
        int success = 25;
        Solution solution = new Solution();

        System.out.println(Arrays.toString(solution.successfulPairs(spells, potions, success)));
    }
}