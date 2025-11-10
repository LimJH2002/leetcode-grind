import java.util.stream.IntStream;

class Solution {
    public long minTime(int[] skill, int[] mana) {
        int[] freeTime =  new int[skill.length];

        for (int i = 0; i < skill.length; i++) {
            freeTime[i] = i == 0
                    ? (skill[i] * mana[i])
                    : freeTime[i - 1] + (skill[i] * mana[i]);
        }

        for (int i = 1; i < mana.length; i++) {
            int difference = 0;
            for (int j = skill.length - 1; j >= 0; j--) {
                if (j == skill.length - 1) {
                    freeTime[j] = freeTime[j] + (skill[j] * mana[i]);
                } else {
                    int newTime = freeTime[j + 1] - (skill[j + 1] * mana[i]);
                    if ()
                }
            }
        }

        return freeTime[skill.length - 1];
    }
}