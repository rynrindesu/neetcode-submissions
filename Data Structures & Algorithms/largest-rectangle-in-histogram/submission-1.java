class Solution {
    public int largestRectangleArea(int[] heights) {

        int n = heights.length;
        int maxArea = 0;
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            // For all elements in the stack taller than heights[i], calculate their height
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                int index = stack.pop();
                int leftBoundary = -1;
                if (!stack.isEmpty()) {
                    leftBoundary = stack.peek();
                }
                int area = (i - leftBoundary - 1) * heights[index];
                maxArea = Math.max(maxArea, area);
            }
            stack.push(i);
        }

        // Remaining elements are bounded on the right by the end of the array 
        while (!stack.isEmpty()) {
                int index = stack.pop();
                int leftBoundary = -1;
                if (!stack.isEmpty()) {
                    leftBoundary = stack.peek();
                }
                int area = (n - leftBoundary - 1) * heights[index];
                maxArea = Math.max(maxArea, area);            
        }

        return maxArea;
    }
}
