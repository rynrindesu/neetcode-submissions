class Solution {
    public boolean isValid(String s) {
        if (s.length() < 2) { return false; }

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            Character c = (Character)s.charAt(i);

            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            }

            if (c == ')') {
                if (stack.isEmpty() || !stack.isEmpty() && stack.pop() != '(') {
                    return false;
                } 
            } else if (c == '}') {
                if (stack.isEmpty() || !stack.isEmpty() && stack.pop() != '{') {
                    return false;
                } 
            } else if (c == ']') {
                if (stack.isEmpty() || !stack.isEmpty() && stack.pop() != '[') {
                    return false;
                } 
            } 

        }

        if (!stack.isEmpty()) {
            return false;
        }

        return true;
    }
}