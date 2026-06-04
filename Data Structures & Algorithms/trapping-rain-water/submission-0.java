class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int[] right = new int[n];

        // Find the maximum barrier height on the right side of each index
        int maxRight = 0;
        for (int i = n - 1; i >= 0; i--) {
            right[i] = maxRight;
            maxRight = height[i] > maxRight? height[i] : maxRight;
        }

        // Water at each index is bounded by the minimum barrier of the left and right maximum
        int maxLeft = 0;
        int waterSum = 0;
        for (int i = 0; i < n; i++) {
            int waterAtIndex = Math.min(maxLeft, right[i]) - height[i];
            // Reduces the need for a dedicated array to store maximum barrier 
            maxLeft = height[i] > maxLeft ? height[i] : maxLeft;
            if (waterAtIndex > 0) {
                waterSum += waterAtIndex;
            }
        }

        return waterSum;
    }
}