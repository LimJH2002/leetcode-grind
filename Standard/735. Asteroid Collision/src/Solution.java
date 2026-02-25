import java.util.Arrays;
import java.util.Stack;

class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        boolean skip = false;

        for (int asteroid : asteroids) {
            skip = false;
            while (!stack.isEmpty() && colliding(stack.peek(), asteroid)) {
                int a = Math.abs(stack.peek());
                int b = Math.abs(asteroid);

                if (a == b) {
                    skip = true;
                    stack.pop();
                    break;
                } else if (a < b) {
                    stack.pop();
                } else {
                    skip = true;
                    break;
                }
            }

            if (!skip) {
                stack.push(asteroid);
            }
        }

        return stack.stream().mapToInt(Integer::intValue).toArray();
    }

    private boolean colliding(int a, int b) {
        return a > 0 && b < 0;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.asteroidCollision(new int[]{-2,1,1,-1})));
    }
}