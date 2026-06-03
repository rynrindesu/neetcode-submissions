class Solution {
    public int evalRPN(String[] tokens) {
        int n = tokens.length; 
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {

            // Used to detect number or operator 
            char c = tokens[i].charAt(tokens[i].length() - 1);
            if (Character.isDigit(c)) {
                int value = Integer.parseInt(tokens[i]);
                stack.push(value);
            } else if (!stack.isEmpty() && !Character.isDigit(c)){
                int b = stack.pop();
                int a = stack.pop();
                int value = calculate(a, b, tokens[i].charAt(0));
                stack.push(value);
            }
        }

        return stack.pop();
    }

    private int calculate(int a, int b, char operator) {
        if (operator == '+') {
            return a + b;
        } else if (operator == '*') {
            return a * b;
        } else if (operator == '/') {
            return a / b;
        }
        return a - b;
    }
}
