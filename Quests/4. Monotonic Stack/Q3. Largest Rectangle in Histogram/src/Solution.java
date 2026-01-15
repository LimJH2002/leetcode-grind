import java.util.Stack;

class Solution {
    public int largestRectangleArea(int[] heights) {
        int maxHeight = 0;
        Stack<Integer> stack = new Stack<>();
        int n = heights.length;

        for (int i = 0; i <= n; i++) {
            int currentElement = i == n ? 0 : heights[i];

            while (!stack.isEmpty() && heights[stack.peek()] > currentElement) {
                int height = heights[stack.pop()];
                int width;

                if (stack.isEmpty()) {
                    width = i;
                } else {
                    width = i - stack.peek() - 1;
                }

                maxHeight = Math.max(maxHeight, width * height);
            }
            stack.push(i);
        }

        return maxHeight;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.largestRectangleArea(new int[] {2, 4}));
    }
}