class Solution {
    public int[] dailyTemperatures(int[] temperatures) {

        class Pair {
            int temp;
            int index;

            public Pair(int temp, int index) {
                this.temp = temp;
                this.index = index;
            }

            public int getTemp() {
                return temp;
            }

            public int getIndex() {
                return index; 
            }
        }

        int n = temperatures.length;
        Stack<Pair> stack = new Stack<>();
        int[] answer = new int[n];

        for (int i = 0; i < n; i++) {
            Pair p1 = new Pair(temperatures[i], i);

            // Record answers for days with temperature cooler than today
            while (!stack.isEmpty() && temperatures[i] > stack.peek().getTemp()) {
                Pair p2 = stack.pop();
                int idx = p2.getIndex();
                answer[idx] = i - idx;
            }

            stack.push(p1);
        }

        // Leftover entries are of days that did not see warmer temperatures
        while (!stack.isEmpty()) {
            Pair p2 = stack.pop();
            answer[p2.getIndex()] = 0;
        }

        return answer;
    }
}