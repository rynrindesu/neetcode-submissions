class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;

        // Store corresponding position and speed entries 
        Map<Integer, Integer> cars = new HashMap<>();
        for (int i = 0; i < n; i++) {
            cars.put(position[i], speed[i]);
        }

        Stack<Double> timeStack = new Stack<>();

        // Sort position of cars in descending order
        List<Integer> sortedOrder = new ArrayList<>(cars.keySet());
        Collections.sort(sortedOrder);

        // For each car, check whether it joins the fleet in the front
        for (int i = n - 1; i >= 0; i--) {
            int pos = sortedOrder.get(i);
            double time = (target - pos) * 1.0 / cars.get(pos);
            // Car does not join the fleet in front if it takes longer for it to reach the target
            if (timeStack.isEmpty() || time > timeStack.peek()) {
                timeStack.push(time);
            }
        }

        return timeStack.size();
    }
}