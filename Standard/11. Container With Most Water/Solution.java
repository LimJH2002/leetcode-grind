class Solution {
    public int maxArea(int[] height) {
        int currentWidth = height.length - 1;
        int currentBest = 0;
        int leftP = 0;
        int rightP = height.length - 1;

        while (leftP <= rightP) {
            int leftHeight = height[leftP];
            int rightHeight = height[rightP];
            int lower = Math.min(leftHeight, rightHeight);
            int area = currentWidth * lower;

            currentBest = Math.max(area, currentBest);

            if (rightHeight == lower) {
                rightP--;
            } else {
                leftP++;
            }

            currentWidth--;
        }

        return currentBest;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] height = {1,8,6,2,5,4,8,3,7};
        System.out.println(s.maxArea(height));
    }
}