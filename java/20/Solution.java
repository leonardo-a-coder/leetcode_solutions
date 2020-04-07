public class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        int len = s.length();
        if ((len & 1) == 1) {
            return false;
        }
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (stack.isEmpty() || !isMatch(stack.pop(), c)) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
    
    private boolean isMatch(char c1, char c2) {
        return (c1 == '(' && c2 == ')') || (c1 == '{' && c2 == '}') || (c1 == '[' && c2 == ']');
    }
}
