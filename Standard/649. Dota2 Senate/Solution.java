import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public String predictPartyVictory(String senate) {
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();

        for (int i = 0; i < senate.length(); i++) {
            if (senate.charAt(i) == 'R') {
                q1.add(i);
            } else {
                q2.add(i);
            }
        }

        while (!q1.isEmpty() && !q2.isEmpty()) {
            int rad = q1.poll();
            int dire = q2.poll();

            if (rad < dire) {
                q1.add(rad + senate.length());
            } else {
                q2.add(dire + senate.length());
            }
        }

        return q1.isEmpty() ? "Dire" : "Radiant";
    }
}