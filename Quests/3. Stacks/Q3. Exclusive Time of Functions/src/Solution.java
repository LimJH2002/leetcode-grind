import java.util.Arrays;
import java.util.List;
import java.util.Stack;

class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();
        int prevTime = 0;

        for (String log : logs) {
            String[] parts = log.split(":");
            int id = Integer.parseInt(parts[0]);
            String type = parts[1];
            int currTime = Integer.parseInt(parts[2]);

            if (type.equals("start")) {
                // If stack is not empty, the function on top was running until now.
                // Give it credit for the duration (currTime - prevTime).
                if (!stack.isEmpty()) {
                    result[stack.peek()] += currTime - prevTime;
                }
                stack.push(id);
                prevTime = currTime;
            } else {
                // "end" means the function on top is finishing.
                // Give it credit for (currTime - prevTime + 1).
                result[stack.peek()] += currTime - prevTime + 1;
                stack.pop();

                // Important: The current second (currTime) is finished.
                // The next function resumes at currTime + 1.
                prevTime = currTime + 1;
            }
        }
        return result;
    }
}