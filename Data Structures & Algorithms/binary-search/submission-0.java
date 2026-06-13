class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int low = 0;
        int high = n - 1;

        while (low < high) {
            int mid = (high + low) / 2;
            if (nums[mid] == target) {
                return mid;
            }

            if (target < nums[mid]) {
                high = mid;
            } else if (target > nums[mid]) {
                low = mid + 1;
            }
        }

        if (low == high && nums[low] == target) {
            return low;
        }

        return -1;
    }
}
