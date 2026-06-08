class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return result;
        }

        int[] sortedNums = Arrays.copyOf(nums, nums.length);
        Arrays.sort(sortedNums);

        Set<List<Integer>> set = new HashSet<>();

        outer: for (int i = 0; i < sortedNums.length - 2; i++) {

            // same numbers will have the same results, or no results
            if (i > 0 && sortedNums[i] == sortedNums[i - 1]) {
                continue outer;
            }

            // main pointers to track which index to continue checking from 
            // one i-th value can have many possible triplet 
            int mainLow = i + 1;
            int mainHigh = sortedNums.length - 1;

            while (mainLow < mainHigh) {

                int lower = mainLow;
                int upper = mainHigh;
                int sum = sortedNums[i] + sortedNums[lower] + sortedNums[upper];

                while (lower < upper && sum != 0) {

                    if (sum < 0) {
                        lower++;
                    } else if (sum > 0) {
                        upper--;
                    }

                    sum = sortedNums[i] + sortedNums[lower] + sortedNums[upper];
                }

                // loop exited due to index overlap, no valid triplet for i-th number 
                if (lower >= upper) { 
                    continue outer; 
                }

                // loop exited due to sum == 0, add valid triplet to set
                Integer[] tempArr = {sortedNums[i], sortedNums[lower], sortedNums[upper]};
                List<Integer> temp = Arrays.asList(tempArr);
                set.add(temp);

                // compare current and next value for lower index, skip duplicates 
                while (lower < upper && sortedNums[lower] == sortedNums[lower + 1]) {
                    lower++;
                }

                // compare current and previous value for upper index, skip duplicates
                while (upper > lower && sortedNums[upper] == sortedNums[upper - 1]) {
                    upper--;
                }

                // pointers and incremented / decremented before moving on to check from next marker
                mainLow = ++lower;
                mainHigh = --upper;

            }
        }

        result = new ArrayList<>(set);
        return result;
       
    }
}