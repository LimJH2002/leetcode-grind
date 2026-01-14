import java.util.Stack;

class Solution {
    class Pair {
        int index;
        int temperature;

        public Pair(int index, int temperature) {
            this.index = index;
            this.temperature = temperature;
        }
    }

    public int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];
        Stack<Pair> stack = new Stack<>();

        for (int i = 0; i < temperatures.length; i++) {
            if (stack.empty()) {
                stack.push(new Pair(i, temperatures[i]));
                continue;
            }

            Pair currentTop = stack.peek();
            int currentTemperature = temperatures[i];

            if (currentTemperature <= currentTop.temperature) {
                stack.push(new Pair(i, currentTemperature));
            } else {
                while (!stack.empty() && currentTemperature > currentTop.temperature) {
                    stack.pop();
                    result[currentTop.index] = i - currentTop.index;
                    if (stack.empty()) {
                        continue;
                    }
                    currentTop = stack.peek();
                }
                stack.push(new Pair(i, currentTemperature));
            }
        }
        return result;
    }
}