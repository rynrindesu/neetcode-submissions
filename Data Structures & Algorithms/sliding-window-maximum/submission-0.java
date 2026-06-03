class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] result = new int[n - k + 1];

        Deque<Integer> queue = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            // Remove elements in the front that are outside the valid window
            while (!queue.isEmpty() && queue.peek() < i - k + 1) {
                queue.pollFirst();
            }

            // Remove obsolete elements (older & smaller than the incoming element)
            while (!queue.isEmpty() && nums[queue.peekLast()] <= nums[i]) {
                queue.pollLast();
            }
            queue.add(i);

            // Add the maximum element of the current window into the results array
            if (i >= k - 1) {
                result[i - k + 1] = nums[queue.peek()];
            }
        }

        return result;
        
    }
}