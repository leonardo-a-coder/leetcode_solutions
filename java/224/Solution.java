public class Solution {
    public int calculate(String s) {
        int result = 0;
        Stack<Boolean> stack = new Stack<>();
        int prev = 0;
        boolean isPositive = true;
        
        stack.push(true);
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= '0' && c <= '9') {
                prev = prev * 10 + c - '0';
            } else if (c == '+' || c == '-') {
                result += isPositive ? prev : -prev;
                prev = 0;
                isPositive = c == '+' ? stack.peek() : !stack.peek();
            } else if (c == '(') {
                stack.push(isPositive);
            } else if (c == ')') {
                stack.pop();
            }
        }
        result += isPositive ? prev : -prev;
        return result;
    }
}
