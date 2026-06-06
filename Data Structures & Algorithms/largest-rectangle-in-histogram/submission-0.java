class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int val = heights[i];
            int pos = i;
            if (map.containsKey(val)) {
                map.get(val).add(pos);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(pos);
                map.put(val, list);
            }
        }

        int maxArea = 0;
        List<Integer> sortedHeights = new ArrayList<>(map.keySet());
        Collections.sort(sortedHeights);
        Collections.reverse(sortedHeights);

        for (Integer i : sortedHeights) {
            List<Integer> pos = map.get(i);
            for (Integer j : pos) {
                int left = j.intValue() - 1;
                int right = j.intValue() + 1;
                while (left >= 0 && heights[left] >= i) {
                    left--;
                } 

                while (right < n && heights[right] >= i) {
                    right++;
                }

                int area = i * (right - left - 1);
                maxArea = Math.max(maxArea, area);
            }
        }
        
        return maxArea; 
    }
}